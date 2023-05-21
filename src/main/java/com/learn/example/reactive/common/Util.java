package com.learn.example.reactive.common;

import net.datafaker.Faker;

public class Util {
    public static Faker faker = new Faker();

    public static void sleepSec(int x) {
        sleepMilliSec(x * 1000);
    }

    public static void sleepMilliSec(int x) {
        try {
            Thread.sleep(x);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
