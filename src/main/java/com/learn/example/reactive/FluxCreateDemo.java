package com.learn.example.reactive;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

public class FluxCreateDemo {

    private static NameProducer nameProducer = new NameProducer();

    public static void main(String[] args) {
        Flux.create(nameProducer)
                .subscribe(s -> System.out.println("Sub" + s), throwable -> System.out.println(throwable.getMessage()), () -> System.out.println("COMPLETED....."));

        // somewhere else in the code flow
        nameProducer.produceData();
    }
}

class NameProducer implements Consumer<FluxSink<String>> {

    FluxSink<String> stringFluxSink;

    @Override
    public void accept(FluxSink<String> stringFluxSink) {
        this.stringFluxSink = stringFluxSink;
    }

    public void produceData () {
        for (int i = 0; i < 10; i++ ) {
            stringFluxSink.next("Emitted  : " + i);
        }

    }
}
