package moe.zaun.prismriver.minor.middleware;

import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.NotAuthorizedException;


@Provider 
public class AuthExceptionMapper implements ExceptionMapper<NotAuthorizedException> { 

    @Override 
    public Response toResponse(NotAuthorizedException e) {
        return Response.status(401).entity("BAD").build();
    } 

} 
