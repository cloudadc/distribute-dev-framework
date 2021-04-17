package io.cloudadc.quarkus;

import javax.ws.rs.GET;
import javax.ws.rs.Path;


@Path("/greeting")
public class GreetingResource {

    @GET
    public String hello() {
        return "{\"response\": \"Hello Quarkus\"}";
    }
}