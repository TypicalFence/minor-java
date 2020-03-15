package moe.zaun.prismriver.minor.controller;

import com.google.inject.Inject;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import moe.zaun.prismriver.minor.service.Greeter;
import moe.zaun.prismriver.minor.model.Cover;
import moe.zaun.prismriver.minor.annotations.RequiresAuth;
import moe.zaun.prismriver.minor.annotations.RequiresAuth;
import moe.zaun.prismriver.minor.dto.SimpleApiResponse;
import moe.zaun.prismriver.minor.dto.ApiResponse;

@Path("hello")
public class HelloController {
    private final Greeter greeter;
    
    @Inject
    public HelloController(final Greeter greeter) {
        this.greeter = greeter;
    }

    @GET
    @Path("/insecure/{name}")
    public String hello(@PathParam("name") final String name) {
        return greeter.greet(name);
    }

    @GET
    @Path("/secure/{name}") 
    @RequiresAuth
    public String sekritHello(@PathParam("name") final String name) {
        return greeter.greet(name);
    }
    
    @GET
    @Path("/cover")
	@Produces("application/json")
    public Cover aaa() {
        Cover cover = new Cover();
        cover.id = "adsadad";
        cover.file = "some.jpg";
        cover.songs = new ArrayList();
        cover.songs.add("lol");
        cover.songs.add("lol");
        return cover;
    }
}
