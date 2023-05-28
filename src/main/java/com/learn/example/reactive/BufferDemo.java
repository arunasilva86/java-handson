package com.learn.example.reactive;

import com.learn.example.reactive.common.DefaultSubscriber;
import com.learn.example.reactive.common.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class BufferDemo {
    public static void main(String[] args) {
        Flux.interval(Duration.ofSeconds(1))
                .buffer(5)
                .subscribe(longs -> longs.stream().forEach(System.out::println));
        Util.sleepSec(25);
    }
}
