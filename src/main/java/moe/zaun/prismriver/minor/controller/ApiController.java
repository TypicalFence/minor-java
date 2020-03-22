package moe.zaun.prismriver.minor.controller;

import moe.zaun.prismriver.minor.dto.ServiceInfo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("api")
public class ApiController {
    
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public ServiceInfo getServiceInfo() {
        return new ServiceInfo(0.1, "minor-java", "minor");
    }

    @GET
    @Path("/ping")
    public String ping() {
        return "pong";
    }
}
