package com.zubova.module1.multithreading.practice.counter.bad;

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
            threads[i] = new Thread(() -> increment1000times(threadCounter));
        }
        return threads;
    }

    private static void increment1000times(ThreadCounter threadCounter) {
        for (int i = 0; i < 1000; i++) {
            threadCounter.increment();
        }
    }
}
