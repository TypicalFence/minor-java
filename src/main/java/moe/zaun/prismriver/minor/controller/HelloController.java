package moe.zaun.prismriver.minor.controller;

import com.google.inject.Inject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import moe.zaun.prismriver.minor.service.Greeter;
import moe.zaun.prismriver.minor.annotations.RequiresAuth;

@Path("hello")
public class HelloController {
    private final Greeter greeter;
    
    @Inject
    public HelloController(final Greeter greeter) {
        this.greeter = greeter;
    }

    @GET
    @Path("{name}")
    public String hello(@PathParam("name") final String name) {
        return greeter.greet(name);
    }

    @GET
    @Path("/secure/{name}") 
    @RequiresAuth
    public String sekritHello(@PathParam("name") final String name) {
        return greeter.greet(name);
    }
}
