package com.learn.example.reactive;

import com.learn.example.reactive.common.DefaultSubscriber;
import com.learn.example.reactive.common.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import reactor.util.function.Tuple3;

import java.time.Duration;

public class CombineLatestDemo {

    public static void main(String[] args) {
        Flux.combineLatest(getMonitor(), getCpu(), (o, o2) ->  o + " / " + o2)

                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(new DefaultSubscriber());

        Util.sleepSec(20);
    }

    private static Flux<String> getMonitor() {
        return Flux.range(1, 5)
                .map(integer -> "Monitor " + integer)
                .delayElements(Duration.ofSeconds(1));
    }

    private static Flux<String>  getCpu() {
        return Flux.range(1, 6)
                .map(integer -> "CPU " + integer)
                .delayElements(Duration.ofSeconds(3));
    }

    private static Flux getKeyBoard() {
        return Flux.range(1, 10)
                .map(integer -> "KeyBoard " + integer)
                .doOnNext(s -> Util.sleepSec(3));
    }
}

