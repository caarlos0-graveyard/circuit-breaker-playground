package com.carlosbecker.circuit.api;

import java.util.Date;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("date")
public class DateResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Date get() {
        return new DateCommand().execute();
    }
}
