package com.learn.example.reactive;

import com.learn.example.reactive.common.DefaultSubscriber;
import com.learn.example.reactive.common.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class BackPreasureDropDemo {
    public static void main(String[] args) {

        System.setProperty("reactor.bufferSize.small", "20"); // queue size set to 20

        /*
        1. queue open
        2. take items until it fill 100 % of its size (20 in this case)
        3. queue closed and drop until any items' comes until it open again
            option is there to run some function on items being dropped and persist/serialize them so that they can be processed later
        4. queue will be opened when its finished consuming 75% of its full size. (in this case after consuming 15th element)
        5. start queuing elements get emits this point onwards until it ful 100 %
        6. continue from step 3
        * */
        Flux.create(fluxSink -> {
                    for (int x = 1; x < 100; x++) {
                        fluxSink.next(x);
                        System.out.println("created : " + x); // done by main thread (the one which subscribes to the flux)
                        Util.sleepMilliSec(5);
                    }
                    fluxSink.complete();
                })
                .onBackpressureDrop(obj -> System.out.println("saved to db for later process " + obj))
                .publishOn(Schedulers.boundedElastic())
                // default is buffer and it keeps items in memory until downstream is ready to accept more
                .doOnNext(obj -> {
                            Util.sleepMilliSec(10);
                            System.out.println("doOnNext : " + obj);
                        }
                ).subscribe(new DefaultSubscriber("Aruna"));

        Util.sleepSec(15);
    }

}
