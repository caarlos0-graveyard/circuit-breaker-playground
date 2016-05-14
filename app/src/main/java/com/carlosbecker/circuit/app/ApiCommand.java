package com.carlosbecker.circuit.app;

import com.jcabi.http.Request;
import com.jcabi.http.request.JdkRequest;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public final class ApiCommand extends HystrixCommand<Integer> {
    private final transient int number;

    public ApiCommand(final int number) {
        super(HystrixCommandGroupKey.Factory.asKey("API"));
        this.number = number;
    }

    @Override
    protected Integer run() throws Exception {
        final String result = new JdkRequest("http://localhost:8082")
            .uri().path("/calc").path(String.format("/%d", this.number)).back()
            .method(Request.POST)
            .fetch()
            .body();
        return Integer.parseInt(result);
    }

    @Override
    protected String getCacheKey() {
        return String.valueOf(this.number);
    }

    @Override
    protected Integer getFallback() {
        return -1;
    }
}
