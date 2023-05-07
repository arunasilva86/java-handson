package com.learn.example.reactive;

import com.learn.example.reactive.common.DefaultSubscriber;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class DelayElementDemo {
    public static void main(String[] args) throws InterruptedException {
        Flux.range(1, 100)
                .log()
                .delayElements(Duration.ofMillis(500))
                .log()
                .subscribe(new DefaultSubscriber());

        Thread.sleep(60000);
    }
}
