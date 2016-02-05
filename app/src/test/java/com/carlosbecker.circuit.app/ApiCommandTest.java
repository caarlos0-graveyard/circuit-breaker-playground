package com.carlosbecker.circuit.app;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public final class ApiCommandTest {
    @Test
    @Ignore
    public void test() {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        try {
            final ApiCommand cmd = new ApiCommand(2);
            final ApiCommand cmd2 = new ApiCommand(2);
            cmd.execute();
            cmd2.execute();
            Assert.assertTrue(cmd2.isResponseFromCache());
        } finally {
            context.shutdown();
        }
        // this will fail, the caching only works in the same request context...
        context = HystrixRequestContext.initializeContext();
        try {
            final ApiCommand cmd = new ApiCommand(2);
            cmd.execute();
            Assert.assertTrue(cmd.isResponseFromCache());
        } finally {
            context.shutdown();
        }
    }
}
