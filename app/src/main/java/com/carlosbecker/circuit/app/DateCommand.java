package com.carlosbecker.circuit.app;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import java.util.Date;

public final class DateCommand extends HystrixCommand<Date> {
    public DateCommand() {
        super(HystrixCommandGroupKey.Factory.asKey("Date"));
    }

    @Override
    protected Date run() throws Exception {
        return new Date();
    }
}
