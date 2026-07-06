package com.zubova.module1.multithreading.practice.pingpong.sync;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainWithExecutorService {

    public static void main(String[] args) throws InterruptedException {
        PingPong game = new PingPong(5);

        int maxThreads = 2;
        try (ExecutorService executorService = Executors.newFixedThreadPool(maxThreads)) {
            CountDownLatch countDownLatch = new CountDownLatch(maxThreads);
            executorService.submit(() -> {
                try {
                    game.playPing();
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

            executorService.submit(() -> {
                try {
                    game.playPong();
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

            countDownLatch.await();
        }

        System.out.println("Game finished.");
    }

}