package com.learn.example.reactive;

import com.learn.example.reactive.common.DefaultSubscriber;
import net.datafaker.Faker;
import reactor.core.publisher.Flux;

import java.util.Locale;

public class FluxGenerateDemo {

    public static Faker faker = new Faker();

    public static void main(String[] args) {
        System.out.println("----------------------Example -1 : Flux generate without state");

        Flux flux = Flux.generate(synchronousSink -> {
            String country = faker.country().name();
            synchronousSink.next(country);
            System.out.println("Emitted : " + country);
            if (country.toLowerCase().equals("canada")) {
                synchronousSink.complete();
            }
        });

        flux.take(5).subscribe(new DefaultSubscriber());

        System.out.println("----------------------Example -2 : Flux generate with state");
        Flux f2 = Flux.generate(() -> 1, (state, syncSink) -> {
            String country = faker.country().name();
            syncSink.next(country);
            if (state == 100 || country.toLowerCase().equals("canada")) {
                syncSink.complete();
            }
            return state + 1;
        });

        f2.take(4).subscribe(new DefaultSubscriber());

    }
}
