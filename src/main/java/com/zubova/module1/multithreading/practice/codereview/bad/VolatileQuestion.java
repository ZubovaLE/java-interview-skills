package com.zubova.module1.multithreading.practice.codereview.bad;

public class VolatileQuestion {

    private static int nonVolatileResult = 0; // it's better to explicitly mark it as volatile
    private static volatile boolean done = false;

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            nonVolatileResult = 13;
            done = true;
        });
        thread.start();
        while (!done) {
            // a bad practise to define a busy-spin loop
        }
        System.out.println(nonVolatileResult);
    }

}