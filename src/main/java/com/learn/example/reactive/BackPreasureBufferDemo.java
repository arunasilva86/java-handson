package com.learn.example.reactive;

import com.learn.example.reactive.common.DefaultSubscriber;
import com.learn.example.reactive.common.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class BackPreasureBufferDemo {
    public static void main(String[] args) {

        Flux.create(fluxSink -> {
                    for (int x = 1; x < 100; x++) {
                        fluxSink.next(x);
                        System.out.println("created : " + x); // done my main thread (the one which subscribe)
                    }
                    fluxSink.complete();
                })
                .publishOn(Schedulers.boundedElastic())
                // default is buffer and it keeps items in memory until downstream is ready to accept more
                .doOnNext(obj -> {
                            Util.sleepMilliSec(100);
                            System.out.println("doOnNext : " + obj);
                        }
                ).subscribe(new DefaultSubscriber("Aruna"));

        Util.sleepSec(15);
    }

}
