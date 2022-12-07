package com.learn.example.reactive;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.util.LinkedList;

public class FluxTest {

    @Test
    public void testBasic () {

        LinkedList<String> stringLinkedList = new LinkedList<>();
        stringLinkedList.add("Aruna");
        stringLinkedList.add("Ishara");
        stringLinkedList.add("Vijitha");
        stringLinkedList.add("Romesh");
        stringLinkedList.add("Prasantha");


        Flux<String> stringFlux = Flux.just("aa", "bb", "cc")
                .map(s -> s.concat("Tail"))
                .concatWith(Flux.just("Hi"))
                .log();

        stringFlux.subscribe(System.out::println, System.out::println, () -> System.out.println("Completed everything"));

    }
}
