package com.learn.example.reactive;

import com.learn.example.reactive.common.DefaultSubscriber;
import reactor.core.publisher.Flux;

public class LimitRateDemo {
    public static void main(String[] args) {
        Flux.range(1, 100)
                .log()
                .limitRate(10, 80) // There will be a request(8) after each eight set consumed by downstream
                .log()
                .subscribe(new DefaultSubscriber());  // initial request(unbounded) call, only once
    }
}
