package moe.zaun.prismriver.minor.middleware;

import moe.zaun.prismriver.minor.dto.StatusApiResponse;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {
    @Override
    public Response toResponse(NotFoundException exception) {
        return Response.status(404).entity(StatusApiResponse.notFound()).build();
    }
}
