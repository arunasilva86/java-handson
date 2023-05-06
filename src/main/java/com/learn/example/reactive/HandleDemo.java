package com.learn.example.reactive;

import com.learn.example.reactive.common.DefaultSubscriber;
import reactor.core.publisher.Flux;

public class HandleDemo {
    public static void main(String[] args) {
        Flux flux = Flux.range(1, 10)
                .map(x -> x * 10)
                .handle((integer, synchronousSink) -> {

                    // Emit integer when integer > 30 and complete when > 70
                    if (integer > 70) {
                        synchronousSink.complete();
                    }
                    if (integer > 30) {
                        synchronousSink.next(integer);
                    }
                });

        flux.subscribe(new DefaultSubscriber());
    }
}
