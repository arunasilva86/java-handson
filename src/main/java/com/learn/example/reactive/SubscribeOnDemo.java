package com.learn.example.reactive;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class SubscribeOnDemo {
    public static void main(String[] args) throws InterruptedException {
        Flux<Object> flux = Flux.create(fluxSink -> {
                    printThreadName("create : ");
                    for (int x = 0; x < 5; x++) {
                        fluxSink.next(x);
                        printThreadName("next : ");
                    }
                    fluxSink.complete();
                })
                .doOnNext(i -> printThreadName(i + " doOnNext 1 : "))
                .doOnNext(i -> printThreadName(i + " doOnNext 2 : "))
                .subscribeOn(Schedulers.boundedElastic())
                .doOnNext(i -> printThreadName(i + " doOnNext 3 : "));


        flux
                .doOnNext(i -> printThreadName(i + " doOnNext 4 : "))
                .doFirst(() -> printThreadName(" doFirst 1 : "))
                .subscribeOn(Schedulers.boundedElastic())
                .doOnNext(i -> printThreadName(i + " doOnNext 5 : "))
                .doFirst(() -> printThreadName(" doFirst 2 : "))
                .subscribe(i -> printThreadName(i + " subscribe : "));

        printThreadName("After subscribe.." );
        Thread.sleep(5000l);
    }

    private static void printThreadName(String i) {
        System.out.println(i + " " + Thread.currentThread().getName());

    }
}
