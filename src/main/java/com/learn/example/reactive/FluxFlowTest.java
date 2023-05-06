package com.learn.example.reactive;

//import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.util.LinkedList;

public class FluxFlowTest {

    public static void main(String[] args) {
        Flux<String> stringFlux =
        /* 1 */        Flux.range(1, 10)
                            .log()
        /* 2 */             .filter(integer -> integer % 2  == 0)
                            .log()
        /* 3 */             .map(integer -> "hi all...")
                            .log()
        /* 4 */             .map(String::toUpperCase);

        stringFlux.log()
        /* 5 */             .map(s -> s + "XX")
                            .log()
        /* 6 */             .filter(s  -> s.startsWith("d"))
                            .log()
                            .subscribe(System.out::println);
    }

//    @Test
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
