package com.carlosbecker.circuit.api;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import javax.annotation.PreDestroy;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("calc")
public class AppResource {
    private final transient HystrixRequestContext context;

    public AppResource() {
        this.context = HystrixRequestContext.initializeContext();
    }

    @PreDestroy
    public void shutdown() {
        this.context.shutdown();
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{number}")
    public int calc(@PathParam("number") final int number) {
        return new ApiCommand(number).execute();
    }
}
