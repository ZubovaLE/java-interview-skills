package com.zubova.module1.multithreading.practice.counter.good.sync;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadCounter threadCounter = new ThreadCounter();
        Thread[] threads = createThreads(threadCounter);
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("Counter value: " + threadCounter.getCounter());
    }

    private static Thread[] createThreads(ThreadCounter threadCounter) {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> performIncrements(threadCounter));
        }
        return threads;
    }

    private static void performIncrements(ThreadCounter threadCounter) {
        for (int i = 0; i < 1000; i++) {
            threadCounter.increment();
        }
    }
}
