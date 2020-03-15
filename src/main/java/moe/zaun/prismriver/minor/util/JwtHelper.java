package moe.zaun.prismriver.minor.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.exceptions.JWTDecodeException;

public class JwtHelper {
    public static String getAlgorithm(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getAlgorithm();
        } catch (JWTDecodeException exception){
            return null;
        }
    }

    public static String getIssuer(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getIssuer();
        } catch (JWTDecodeException exception){
            return "";
        }
    }
}
