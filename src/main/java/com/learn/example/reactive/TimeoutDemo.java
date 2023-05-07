package com.learn.example.reactive;

import com.learn.example.reactive.common.DefaultSubscriber;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class TimeoutDemo {
    public static void main(String[] args) throws InterruptedException {
        Flux flux = Flux.range(1, 6)
                .doOnCancel(() -> System.out.println("doOnCancel-1 "))
                .delayElements(Duration.ofSeconds(4));

        flux.log()
                .doOnCancel(() -> System.out.println("doOnCancel-2 "))
                .timeout(Duration.ofSeconds(3), getAnotherPublisher()) // when exceed 3sec, get from another publisher
                .log()
                .subscribe(new DefaultSubscriber());

        Thread.sleep(30000);
    }


    public static Flux<String> getAnotherPublisher() {
        return Flux.just("aaa", "bbb", "ccc")
                .log()
                .delayElements(Duration.ofSeconds(2));

    }
}
