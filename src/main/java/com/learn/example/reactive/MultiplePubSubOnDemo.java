package com.learn.example.reactive;

import com.learn.example.reactive.common.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class MultiplePubSubOnDemo {

    public static void main(String[] args) throws InterruptedException {
        Flux<Object> flux = Flux.create(fluxSink -> {
                    Util.printThreadName("create : ");
                    for (int x = 0; x < 5; x++) {
                        fluxSink.next(x);
                        Util.printThreadName(x + " next : ");
                    }
                    fluxSink.complete();
                })
                .doOnNext(i -> Util.printThreadName(i + " doOnNext A : "))
                .subscribeOn(Schedulers.boundedElastic())
                .doOnNext(i -> Util.printThreadName(i + " doOnNext B : ")) // upto to this point wo from publisher, work is done by the thread defined in line 18 (when multiple subscribe on --> closest one to the publisher become relavent untill we found the first publishOn)
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> Util.printThreadName(i + " doOnNext C : ")); // doOnNext C and doOnNext D done by thread defined in line 19, publishOn effect on down stream


        flux
                .doOnNext(i -> Util.printThreadName(i + " doOnNext D : "))
                .subscribeOn(Schedulers.boundedElastic())
                .doFirst(() -> Util.printThreadName(" doFirst 1 : "))
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> Util.printThreadName(i + " doOnNext E : ")) // doOnNext E and subscribe consumer done by thread defined in line 26
                .doFirst(() -> Util.printThreadName(" doFirst 2 : "))
                .subscribe(i -> Util.printThreadName(i + " subscribe : "));

        // 4 threads work in parallel in  areas in this pipeline  (main / parallel-1 / boundedElastic-3 / boundedElastic-1)

        Util.printThreadName("After subscribe..");
        Thread.sleep(5000l);
    }

}
