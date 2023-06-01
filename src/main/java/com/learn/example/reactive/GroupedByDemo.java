package com.learn.example.reactive;

import com.learn.example.reactive.common.DefaultSubscriber;
import com.learn.example.reactive.common.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class GroupedByDemo {

    public static void main(String[] args) {
        Flux.range(1, 20)
                .delayElements(Duration.ofSeconds(1))
                .groupBy(aLong -> aLong % 2 ) // aLong % 2 defined the possible key values. in thins case [0, 1]
                .subscribe(integerIntegerGroupedFlux -> processGroupedFlux(integerIntegerGroupedFlux, integerIntegerGroupedFlux.key()));
        // integerIntegerGroupedFlux means key is integer and value is inteher of the flux

        Util.sleepSec(25);
    }

    public static void processGroupedFlux (Flux<Integer> flux, int key) {
        System.out.println("Called .. ");
        flux.subscribe(integer -> System.out.println("Key : " + key + ", Item : " + integer));

    }
}
