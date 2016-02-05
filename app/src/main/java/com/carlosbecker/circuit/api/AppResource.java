package com.carlosbecker.circuit.api;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("calc")
public class AppResource {
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{number}")
    public int calc(@PathParam("number") final int number) {
        return new ApiCommand(number).execute();
    }
}
