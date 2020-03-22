package moe.zaun.prismriver.minor.middleware;

import com.google.inject.Inject;
import moe.zaun.prismriver.minor.annotations.RequiresAuth;
import moe.zaun.prismriver.minor.service.interfaces.TrustedPublicKeysService;

import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;
import java.lang.reflect.Method;

@Provider
public class AuthFilterFeature implements DynamicFeature {
    
    private final TrustedPublicKeysService publicKeyService;
    
    @Inject
    public AuthFilterFeature(TrustedPublicKeysService publicKeyService) {
        this.publicKeyService = publicKeyService;
    }   
    
    @Override
    public void configure(ResourceInfo resourceInfo, FeatureContext context) {
        Method method = resourceInfo.getResourceMethod();
        if (method.isAnnotationPresent(RequiresAuth.class)) {
            context.register(new AuthFilter(publicKeyService));
        }
    }
}
