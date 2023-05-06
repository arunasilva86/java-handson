package com.learn.example.reactive;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

public class StockPriceDemo {

    private static Long value = 100l;

    public static void main(String[] args) throws InterruptedException {
        Flux<Long> stockValueFlux = Flux.interval(Duration.ofMillis(500))
                .map(aLong -> {
                    value += ThreadLocalRandom.current().nextInt(-5, 6);
                    return value;
                });

        stockValueFlux.subscribeWith(new MySubscriber());
        Thread.sleep(100000);
    }
}

class MySubscriber<T extends Long> extends BaseSubscriber<T>  {

    @Override
    public void hookOnSubscribe(Subscription s) {

        System.out.println("Subscribed ... ");
        request(1);
    }

    @Override
    public void hookOnNext(Long aLong) {
        System.out.println("Received stock value : " + aLong);
        if (aLong > 110 || aLong < 90) {
            System.out.println("I'm off..... : " + aLong);
            cancel();
        }
        request(1);
    }

    @Override
    public void hookOnComplete() {

        System.out.println("FINISHED...");
    }
}
