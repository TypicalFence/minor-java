package moe.zaun.prismriver.minor.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;


@Path("api")
public class ApiController {
    
    @GET
    @Path("/")
    public String hello() {
        return "api";
    }

    @GET
    @Path("/ping") 
    public String sekritHello() {
        return "pong";
    }
}
