package com.zubova.module1.multithreading.practice.codereview.good;

public class VolatileQuestion {

    private static volatile int nonVolatileResult = 0;

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            nonVolatileResult = 13;
        });
        thread.start();

        // Use thread.join() to efficiently wait for completion, avoiding a busy-spin loop
        try {
            thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(nonVolatileResult);
    }

}