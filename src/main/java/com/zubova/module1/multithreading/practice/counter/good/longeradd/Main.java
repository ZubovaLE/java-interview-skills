package com.zubova.module1.multithreading.practice.counter.good.longeradd;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadCounter threadCounter = new ThreadCounter();
        int threadCount = 10;
        int incrementsPerThread = 100;

        try (ExecutorService executorService = Executors.newFixedThreadPool(threadCount)) {
            CountDownLatch countDownLatch = new CountDownLatch(threadCount);
            for (int i = 0; i < threadCount; i++) {
                executorService.submit(() -> {
                    performIncrements(incrementsPerThread, threadCounter);
                    countDownLatch.countDown();
                });
            }
            countDownLatch.await();
            executorService.shutdown();
        }

        System.out.println("Counter value: " + threadCounter.getCounter());
    }

    private static void performIncrements(int incrementsPerThread, ThreadCounter threadCounter) {
        for (int i = 0; i < incrementsPerThread; i++) {
            threadCounter.increment();
        }
    }
}
