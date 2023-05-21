package com.learn.example.reactive;

import com.learn.example.reactive.common.DefaultSubscriber;
import net.datafaker.Faker;
import net.datafaker.sequence.FakeCollection;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class HandleDemo {
    public static void main(String[] args) {
        Flux flux = Flux.range(1, 10)
                .map(x -> {
                    System.out.println("Handling thread is  : " + Thread.currentThread().getName());
                    return x * 10;
                })

                .subscribeOn(Schedulers.boundedElastic())
                .handle((integer, synchronousSink) -> {

                    // Emit integer when integer > 30 and complete when > 70
                    if (integer > 70) {
                        synchronousSink.complete();
                    } else if (integer > 30) {
                        synchronousSink.next(integer);
                    }
                });

        flux.subscribe(new DefaultSubscriber("xxx"));
        flux.subscribe(new DefaultSubscriber("yyy"));

        System.out.println("------------------canada example with handle");


        Faker faker = new Faker();
        Flux  flux2 = Flux.generate(synchronousSink -> synchronousSink.next(faker.country().name()))
                .map(Object::toString)
                .handle((s, synchronousSink) -> {
                    synchronousSink.next(s);
                    if ("Canada".equals(s)) {
                        synchronousSink.complete();
                    }
                });
        flux2.subscribe(new DefaultSubscriber());

    }


}
