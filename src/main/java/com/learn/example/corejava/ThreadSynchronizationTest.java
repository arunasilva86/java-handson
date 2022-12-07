package com.learn.example.corejava;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ThreadSynchronizationTest {

    public static void main(String[] args) {
        Backery backery = new Backery();
        backery.setBreadBucket(new ArrayList<>());

        Backer backer = new Backer();
        backer.setBackery(backery);

        List<Rider> riders = IntStream.rangeClosed(1, 10)
                .mapToObj(value -> new Rider(value, backery))
                .collect(Collectors.toList());

        CompletableFuture.runAsync(backer)
                .thenAccept(unused -> System.out.println("All breads are added to bucket...."));

        riders.stream().forEach(rider -> CompletableFuture.supplyAsync(() -> rider.getBread()).thenAccept(bread -> System.out.println("Delivered, Bread id  : "+ bread.id() + " Rider id : " + rider.getId())));

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Backery {
    private List<Bread> breadBucket;

    public Bread collectBread () {
        Bread bread = null;
        synchronized (breadBucket) {
            if (breadBucket.isEmpty()) {
                try {
                    System.out.println("Empty Bucket, Going wait....");
                    breadBucket.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            bread = breadBucket.remove(0);
        }
        return bread;
    }

    public void addBread (Bread bread) {
        synchronized (breadBucket) {
            breadBucket.add(bread);
            System.out.println("Added Bread ....id : "+ bread.id());
            breadBucket.notify();
        }
    }

    public List<Bread> getBreadBucket() {
        return breadBucket;
    }

    public void setBreadBucket(List<Bread> breadBucket) {
        this.breadBucket = breadBucket;
    }
}

class Backer implements Runnable {
    private Backery backery;

    public void setBackery(Backery backery) {
        this.backery = backery;
    }

    @Override
    public void run () {
        IntStream.rangeClosed(1, 10).mapToObj(Bread::new)
                .peek(bread -> {
                    try {
                        Thread.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                })
                .forEach(backery::addBread);
    }
}

class Rider {

    private Backery backery;
    private int id;

    public Rider (int id, Backery backery) {
        this.id = id;
        this.backery = backery;
    }

    public Bread getBread() {
        Bread bread = backery.collectBread();
        return bread;
    }

    public int getId() {
        return id;
    }
}

record Bread (int id) {

    public Bread (int id) {
        this.id = id;
    }
}