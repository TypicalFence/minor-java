package moe.zaun.prismriver.minor.middleware;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.inject.Inject;
import moe.zaun.prismriver.minor.service.interfaces.TrustedPublicKeysService;
import moe.zaun.prismriver.minor.util.JwtHelper;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;

@Provider
public class AuthFilter implements ContainerRequestFilter {

    private final TrustedPublicKeysService publicKeyService;
    
    @Inject
    public AuthFilter(TrustedPublicKeysService publicKeyService) {
        this.publicKeyService = publicKeyService;
    }
    
    @Override
    public void filter(ContainerRequestContext request) {
        String authHeader = request.getHeaderString(HttpHeaders.AUTHORIZATION);
        if (authHeader == null) {
            throw new NotAuthorizedException("Bearer");
        }
        
        String token = this.getTokenFromHeader(authHeader);

        if (token == null) {
            throw new NotAuthorizedException("no Token");
        }
        
        if (!this.verifyToken(token)) {
            throw new NotAuthorizedException("invalid Token");
        }
    }
    
    private String getTokenFromHeader(String authHeader) {
        String[] splitHeader = authHeader.split(" ");

        if (splitHeader.length != 2) {
            return null;
        }

        return splitHeader[1];
    }

    private boolean verifyToken(String token) {
        Algorithm algorithm = this.getAlgorithm(token);

        if (algorithm == null) {
            return false;
        }
        
        try {
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (JWTVerificationException exception) {
            return false;
        }
    }

    private Algorithm getAlgorithm(String token) {
        String issuer = JwtHelper.getIssuer(token);
        PublicKey publicKey = this.publicKeyService.getPublicKey(issuer);
        
        try {
            String algorithm = JwtHelper.getAlgorithm(token);

            if (algorithm.equals("RS256")) {
                return Algorithm.RSA256((RSAPublicKey) publicKey, null);
            }

            return null;

        } catch (JWTDecodeException exception) {
            return null;
        }
    }
}
