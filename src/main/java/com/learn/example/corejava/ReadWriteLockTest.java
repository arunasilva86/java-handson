package com.learn.example.corejava;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

public class ReadWriteLockTest {
    public static void main(String[] args) {

        ExchangeRateManager exchangeRateManager = new ExchangeRateManager();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

//        IntStream.rangeClosed(1, 10).forEach(value -> {
//            Future<Float> currencyValue = executorService.submit(() -> exchangeRateManager.updateRates(value, Float.valueOf(value * 100)));
//        });

        IntStream.range(1, 10).forEach(value -> {
            Future<Float> currencyValue1 = executorService.submit(() -> exchangeRateManager.updateRates(value, Float.valueOf(value * 100)));
            Future<Float> currencyValue2 = executorService.submit(() -> exchangeRateManager.readRates(value));
        });
        executorService.shutdown();
    }
}

class ExchangeRateManager {

    private Map<Integer, Float> exchangeRates = new HashMap<>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public Float readRates (Integer currencyCode) {
        try {
            lock.readLock().lock();
            System.out.println("Before read");
            Float value = exchangeRates.get(currencyCode);
            System.out.println("Read done : value = " + value);
            return value != null ? value : Float.valueOf(0);
        } finally {
            lock.readLock().unlock();
        }
    }

    public Float updateRates (Integer currencyCode, Float value) {
        System.out.println("Before update");
        lock.writeLock().lock();
        Float returnValue = null;
        try {
            Thread.sleep(3000);
            exchangeRates.put(currencyCode, value);
            System.out.println("Update done");
            returnValue = exchangeRates.get(currencyCode);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
        return returnValue;
    }

}

class Reader {
    private int id;

}

