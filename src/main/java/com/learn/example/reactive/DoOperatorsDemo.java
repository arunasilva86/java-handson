package com.learn.example.reactive;

import com.learn.example.reactive.common.DefaultSubscriber;
import com.learn.example.reactive.common.Util;
import reactor.core.publisher.Flux;

public class DoOperatorsDemo {

    public static void main(String[] args) {
        Flux.create(fluxSink -> {
            System.out.println("Inside create ... ");
            for (int x = 1; x <= 5; x++) {
                fluxSink.next(x);
            }
            fluxSink.complete();

        })
                .doOnNext(o -> System.out.println("doOnNext-1"))
                .doOnNext(o -> System.out.println("doOnNext-2"))
                .doOnNext(o -> Util.sleepSec(2))
                .doOnComplete(() -> System.out.println("doOnComplete-1"))
                .doOnComplete(() -> System.out.println("doOnComplete-2"))
                .doOnRequest(value -> System.out.println("doOnRequest-1"))
                .doOnRequest(value -> System.out.println("doOnRequest-2"))
                .doOnSubscribe(o -> System.out.println("doOnSubscribe-1"))
                .doOnSubscribe(o -> System.out.println("doOnSubscribe-2"))
        .subscribe(new DefaultSubscriber());

        System.out.println("Final sout.....");

    }
}
