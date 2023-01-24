package com.learn.example.corejava;

import java.util.concurrent.*;

public class ExecutorServiceTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        singleThreadExecutorExample();
        scheduledThreadExecutorExample();
//        callableExample();

    }

    private static void callableExample () throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<String> callable = () -> "Hi All...";
        Future<String> stringFuture = executorService.submit(callable);
        String s = stringFuture.get();
        System.out.println(s);
        executorService.shutdown();
    }

    private static void scheduledThreadExecutorExample() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        Runnable runnable_1 = () -> {
            System.out.println("task -1 started");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task -1 completed");
        };
        Runnable runnable_2 =
                () -> {
                    System.out.println("task -2 started");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("task -2 completed");
                };
        scheduledExecutorService.schedule(runnable_1, 6, TimeUnit.SECONDS);
        scheduledExecutorService.schedule(runnable_2, 5, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();
    }

    private static void singleThreadExecutorExample() {
        Runnable runnable = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("inside Runnable .. ");
        };
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(runnable);
        executorService.shutdown();
    }
}
