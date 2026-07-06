package com.zubova.module1.multithreading.practice.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);
        try (ExecutorService executorService = Executors.newFixedThreadPool(5)) {
            executorService.submit(new Producer(queue, "Producer-1"));
            executorService.submit(new Producer(queue, "Producer-2"));
            executorService.submit(new Consumer(queue, "Consumer-1"));
            executorService.submit(new Consumer(queue, "Consumer-2"));
            executorService.submit(new Consumer(queue, "Consumer-3"));
            try {
                Thread.sleep(2000);
                executorService.shutdownNow();
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }
    }
}
