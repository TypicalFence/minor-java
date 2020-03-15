package moe.zaun.prismriver.minor.modules;

import com.google.inject.Binder;
import com.google.inject.Module;
import moe.zaun.prismriver.minor.middleware.AuthFilterFeature;
import moe.zaun.prismriver.minor.middleware.AuthExceptionMapper;
import moe.zaun.prismriver.minor.service.interfaces.TrustedPublicKeysService;
import moe.zaun.prismriver.minor.service.FakeTrustedPublicKeyService;

public class MainModule implements Module {
   public void configure(final Binder binder) {
       binder.bind(AuthFilterFeature.class);
       binder.bind(AuthExceptionMapper.class);
       binder
           .bind(TrustedPublicKeysService.class)
           .to(FakeTrustedPublicKeyService.class);
   }
}
