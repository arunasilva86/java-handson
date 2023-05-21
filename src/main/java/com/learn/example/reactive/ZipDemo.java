package com.learn.example.reactive;

import com.learn.example.reactive.common.DefaultSubscriber;
import com.learn.example.reactive.common.Util;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple3;

public class ZipDemo {

    public static void main(String[] args) {
        Flux<Tuple3> zippedFlux = Flux.zip(getMonitor(), getCpu(), getKeyBoard());

        zippedFlux
                .doOnNext(o -> System.out.println("doOnNext " + " Monitor-" + o.getT1() + " CPU-" + o.getT2() + " KeyBoard-" + o.getT3()))
                .subscribe(new DefaultSubscriber());
    }

    private static Flux getMonitor() {
        return Flux.range(1, 5)
                .map(integer -> "Monitor " + integer)
                .doOnNext(s -> Util.sleepSec(1));
    }

    private static Flux getCpu() {
        return Flux.range(1, 3)
                .map(integer -> "CPU " + integer)
                .doOnNext(s -> Util.sleepSec(2));
    }

    private static Flux getKeyBoard() {
        return Flux.range(1, 10)
                .map(integer -> "KeyBoard " + integer)
                .doOnNext(s -> Util.sleepSec(3));
    }
}

