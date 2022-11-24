package org.acme;

import org.acme.service.GreetingService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@Path("/hello")
public class GreetingResource {

    @Inject
    private GreetingService greetingService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(){
        return greetingService.sayHello();
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@PathParam("name") String name) {
        return greetingService.sayHello(name);
    }
}