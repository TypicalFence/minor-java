package moe.zaun.prismriver.minor.controller;

import com.google.inject.Inject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import moe.zaun.prismriver.minor.service.Greeter;
import moe.zaun.prismriver.minor.annotations.RequiresAuth;


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
