package com.learn.example.reactive;

import com.learn.example.reactive.common.DefaultSubscriber;
import com.learn.example.reactive.common.Util;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

public class SinksDemo {

    public static void main(String[] args) {

        Sinks.One<Integer> sink = Sinks.one();



        sink.asMono()
                .subscribe(new DefaultSubscriber("Aruna"));

        System.out.println("before emit");
        sink.tryEmitValue(150);
//        Util.sleepSec(10);

    }
}
