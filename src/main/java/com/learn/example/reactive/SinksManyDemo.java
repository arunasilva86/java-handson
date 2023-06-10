package com.learn.example.reactive;

import com.learn.example.reactive.common.DefaultSubscriber;
import com.learn.example.reactive.common.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.core.scheduler.Schedulers;

public class SinksManyDemo {
    public static void main(String[] args) {
        Sinks.Many<Integer> intSinks = Sinks.many().multicast().onBackpressureBuffer();

        intSinks.tryEmitNext(10);
        intSinks.tryEmitNext(20);

        Flux<Integer> integerFlux =  intSinks.asFlux();

        integerFlux
                .doOnNext(integer -> Util.printThreadName(integer + " Aruna "))
                .subscribe(new DefaultSubscriber("Aruna"));

        intSinks.tryEmitNext(30);

        integerFlux
                .publishOn(Schedulers.boundedElastic()) // Each subscriber can decide processing thread model of it
                .doOnNext(integer -> Util.printThreadName(integer + " Ishara "))
                .subscribe(new DefaultSubscriber("Ishara")); // if unicast() is used Ishara will get an ERROR signal

        intSinks.tryEmitNext(40); // Ishara eceive only 40, 50 60. While Aruna receive all
        intSinks.tryEmitNext(50);
        intSinks.tryEmitNext(60);

        Util.sleepSec(10);
    }
}
