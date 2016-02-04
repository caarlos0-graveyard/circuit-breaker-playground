package com.carlosbecker.circuit.api;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("calc")
public class ApiResource {
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{number}")
    public int calc(@PathParam("number") final int number) throws InterruptedException {
        if (System.currentTimeMillis() % 5 == 0)
            Thread.sleep(1000L);
        return number * 20;
    }
}
