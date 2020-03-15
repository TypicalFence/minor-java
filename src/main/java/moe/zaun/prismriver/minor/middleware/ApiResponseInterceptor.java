package moe.zaun.prismriver.minor.middleware;

import java.io.IOException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;
import com.google.common.base.Optional;
import moe.zaun.prismriver.minor.dto.ApiResponse;
import moe.zaun.prismriver.minor.dto.SimpleApiResponse;
import moe.zaun.prismriver.minor.model.Model;

@Provider
public class ApiResponseInterceptor implements WriterInterceptor {
    public void aroundWriteTo(WriterInterceptorContext context) throws IOException {
        Object entity = context.getEntity();
        Optional<ApiResponse> response = this.getApiResponse(entity);

        if (response.isPresent()) {
            context.setEntity(response.get());
        }

        context.proceed();
    }

    private Optional<ApiResponse> getApiResponse(Object entity) {
        if (entity instanceof Model) {
            SimpleApiResponse response = new SimpleApiResponse();
            response.setStatus(200);
            response.setMessage("ok");
            response.setData((Model) entity);
            return Optional.of(response);
        }

        return Optional.absent();
    }
}
