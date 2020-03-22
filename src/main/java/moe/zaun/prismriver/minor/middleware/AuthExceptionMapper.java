package moe.zaun.prismriver.minor.middleware;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider 
public class AuthExceptionMapper implements ExceptionMapper<NotAuthorizedException> { 

    @Override 
    public Response toResponse(NotAuthorizedException e) {
        return Response.status(401).entity("BAD").build();
    } 

} 
