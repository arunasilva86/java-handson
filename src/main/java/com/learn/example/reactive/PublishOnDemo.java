package com.learn.example.reactive;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class PublishOnDemo {

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
                .doOnNext(i -> printThreadName(i + " doOnNext 2 : ")) // upto to this point wo from publisher, work is done by mail thread
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> printThreadName(i + " doOnNext 3 : ")); // doOnNext 3 and doOnNext 4 done by thread defined in line 19


        flux
                .doOnNext(i -> printThreadName(i + " doOnNext 4 : "))
                .doFirst(() -> printThreadName(" doFirst 1 : "))
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> printThreadName(i + " doOnNext 5 : ")) // doOnNext 5 and subscribe consumer done by thread defined in line 26
                .doFirst(() -> printThreadName(" doFirst 2 : "))
                .subscribe(i -> printThreadName(i + " subscribe : "));

        // 3 threads work in parallel in 3 areas in this pipeline  (main / boundedElastic-2/ boundedElastic-1)

        printThreadName("After subscribe..");
        Thread.sleep(5000l);
    }

    private static void printThreadName(String i) {
        System.out.println(i + " " + Thread.currentThread().getName());

    }
}


