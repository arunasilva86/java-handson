package com.learn.example.reactive;

import com.learn.example.reactive.common.DefaultSubscriber;
import com.learn.example.reactive.common.Util;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

public class SinksOneDemo {

    public static void main(String[] args) {

        Sinks.One<Integer> sink = Sinks.one();

        sink.asMono()
                .doOnNext(integer -> Util.printThreadName(integer))
                .subscribe(new DefaultSubscriber("Aruna"));

        Util.printThreadName("before emit : ");
        sink.tryEmitValue(150);
        Util.printThreadName("after emit : ");
//        Util.sleepSec(10);

    }
}
