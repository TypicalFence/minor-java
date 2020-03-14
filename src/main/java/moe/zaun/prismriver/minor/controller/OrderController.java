package moe.zaun.prismriver.minor.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("orders")
public class OrderController {
	
    @Path("{id}")
	@GET
	@Produces("text/plain")
	public String getOrder(@PathParam("id") String id) {
		return "Order Id: " + id;
	}

}
