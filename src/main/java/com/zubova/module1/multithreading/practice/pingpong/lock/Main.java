package com.zubova.module1.multithreading.practice.pingpong.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        PingPongWithLock game = new PingPongWithLock(5);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            try {
                game.playPing();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        executorService.submit(() -> {
            try {
                game.playPong();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("Game finished.");
    }

}