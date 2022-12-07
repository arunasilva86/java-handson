package com.learn.example.corejava;

import java.util.concurrent.CompletableFuture;

public class ComletableFuureTest {
    public static void main (String []  args) throws InterruptedException {
        System.out.println("Main : " + Thread.currentThread().getName());
        CompletableFuture.supplyAsync(() -> String.valueOf(10))
                .thenApply(Integer::valueOf)
                .thenApply(integer -> "my int value : " + integer)
                .thenAccept(System.out::println);
        Thread.sleep(1000);
    }
}
