package com.learn.example.reactive;

import com.learn.example.reactive.common.DefaultSubscriber;
import com.learn.example.reactive.common.Util;
import net.datafaker.Faker;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

public class CarPriceDepreciateDemo {
    public static void main(String[] args) {
        Flux<Long> valueFlux = Flux.create(fluxSink -> {
            long currentValue = 10000;
            for (long value = currentValue; value > 0; value = value - 10) {
                fluxSink.next(value);
                Util.sleepMilliSec(100);
            }
            fluxSink.complete();
        })
                .cast(Long.class)
                .subscribeOn(Schedulers.boundedElastic());

        Flux<Double> demandFactorFlux = Flux.interval(Duration.ofMillis(30))
                .map(aLong -> Util.faker.random().nextDouble(0.8, 1.2))
                .cast(Double.class);

        Flux.combineLatest(valueFlux, demandFactorFlux, (value, demand) -> value * demand)
                .subscribe(new DefaultSubscriber());
        Util.sleepSec(100);


    }
}
