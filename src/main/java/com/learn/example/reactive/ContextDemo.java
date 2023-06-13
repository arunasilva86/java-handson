package com.learn.example.reactive;

import com.learn.example.reactive.common.DefaultSubscriber;
import reactor.core.publisher.Flux;
import reactor.util.context.Context;

public class ContextDemo {

    public static void main(String[] args) {
        getIntFlux()
                .contextWrite(Context.of("userName", "admin")) // setting context with relevant values
                .subscribe(new DefaultSubscriber("Aruna "));

    }

    public static Flux<Integer> getIntFlux () {
        return Flux.deferContextual(contextView -> {
            if ("admin".equals(contextView.get("userName"))) { // Check context values in incoming requests
                return Flux.range(1, 10);
            } else {
                return Flux.error(new RuntimeException("Access denied.. "));
            }
        });


    }
}
