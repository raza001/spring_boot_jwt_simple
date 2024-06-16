package com.model.token.jwttoken;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class asyncMethodWithVoidReturnType {
    @Async
    public void asyncMethodWithVoidReturn() {
        System.out.println("Execute method asynchronously. "
                + Thread.currentThread().getName());
    }
}
