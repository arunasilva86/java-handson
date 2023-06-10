package com.learn.example.reactive;

import com.learn.example.reactive.common.DefaultSubscriber;
import com.learn.example.reactive.common.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.core.scheduler.Schedulers;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class SinksThreadSafetyDemo {

    public static void main(String[] args) {
        Sinks.Many<Integer> intSinks = Sinks.many().multicast().onBackpressureBuffer();

        intSinks.tryEmitNext(10);
        intSinks.tryEmitNext(20);

        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7,8);
        list.stream().forEach(number -> CompletableFuture.runAsync(() -> {
            Util.sleepMilliSec(500);
//            intSinks.tryEmitNext(number); // If you  Run with this, some of the threads wont be able to emit with intSynac.
            intSinks.emitNext(number, (signalType, emitResult) -> true); // But with this we ask to retry, if fails..

        }));
        intSinks.asFlux().subscribe(new DefaultSubscriber("Aruna : "));

        Util.sleepSec(10);
    }
}
