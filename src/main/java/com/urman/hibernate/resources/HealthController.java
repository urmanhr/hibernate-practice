package com.urman.hibernate.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

@Component
@Path("/health")
public class HealthController {
	
	@GET
    @Produces({"application/json"})
	public Response jersey() {
        return Response.ok("Applictaion is Running").build();
    }

}
