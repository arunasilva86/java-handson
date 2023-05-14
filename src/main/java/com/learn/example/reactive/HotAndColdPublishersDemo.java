package com.learn.example.reactive;

import com.learn.example.reactive.common.DefaultSubscriber;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class HotAndColdPublishersDemo {
    public static void main(String[] args) throws InterruptedException {
        Flux flux = Flux.range(1, 10)
                .map(integer -> "Scene : " + integer)
                .delayElements(Duration.ofSeconds(1))
                .publish()
                .refCount(1);

        flux.subscribe(new DefaultSubscriber("John"));

        Thread.sleep(5000l);

        flux.subscribe(new DefaultSubscriber("Ann"));

        Thread.sleep(50000l);
    }
}
