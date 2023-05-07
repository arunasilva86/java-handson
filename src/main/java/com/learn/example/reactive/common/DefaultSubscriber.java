package com.learn.example.reactive.common;


import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class DefaultSubscriber implements Subscriber<Object> {

    @Override
    public void onSubscribe(Subscription s) {
        s.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(Object o) {
        System.out.println("Received : " + o);
    }


    @Override
    public void onError(Throwable t) {
        System.out.println("ERROR Received : " + t.getMessage());

    }

    @Override
    public void onComplete() {
        System.out.println("COMPLETE Received");
    }
}
