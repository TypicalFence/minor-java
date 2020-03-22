package moe.zaun.prismriver.minor.modules;

import com.google.inject.Binder;
import com.google.inject.Module;
import moe.zaun.prismriver.minor.controller.ApiController;
import moe.zaun.prismriver.minor.middleware.ApiResponseInterceptor;
import moe.zaun.prismriver.minor.middleware.AuthExceptionMapper;
import moe.zaun.prismriver.minor.middleware.AuthFilterFeature;
import moe.zaun.prismriver.minor.middleware.BadRequestExceptionMapper;
import moe.zaun.prismriver.minor.middleware.NotFoundExceptionMapper;
import moe.zaun.prismriver.minor.service.FakeTrustedPublicKeyService;
import moe.zaun.prismriver.minor.service.interfaces.TrustedPublicKeysService;

public class MainModule implements Module {
   public void configure(final Binder binder) {
       binder.bind(AuthFilterFeature.class);
       binder.bind(AuthExceptionMapper.class);
       binder.bind(ApiResponseInterceptor.class);
       binder.bind(BadRequestExceptionMapper.class);
       binder.bind(NotFoundExceptionMapper.class);
       binder.bind(ApiController.class);
       binder
           .bind(TrustedPublicKeysService.class)
           .to(FakeTrustedPublicKeyService.class);
   }
}
