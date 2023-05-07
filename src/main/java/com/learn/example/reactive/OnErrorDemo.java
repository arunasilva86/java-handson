package com.learn.example.reactive;

import com.learn.example.reactive.common.DefaultSubscriber;
import reactor.core.publisher.Flux;

public class OnErrorDemo {
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
                    fluxSink.next(5);
                    fluxSink.next(6 / 0);

                })
                .onErrorReturn(-1)
                .subscribe(new DefaultSubscriber());
    }
}
