package com.carlosbecker.circuit.api;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import java.util.Date;

public final class DateCommand extends HystrixCommand<Date> {
    public DateCommand() {
        super(HystrixCommandGroupKey.Factory.asKey("API"));
    }

    @Override
    protected Date run() throws Exception {
        return new Date();
    }
}
