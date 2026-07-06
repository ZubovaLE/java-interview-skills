package com.zubova.module1.multithreading.practice.producerconsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private final BlockingQueue<Integer> queue;
    private final String name;

    public Consumer(BlockingQueue<Integer> queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Integer number = queue.take();
                System.out.printf("%s consumed %d. Queue size: %d%n", name, number, queue.size());
                Thread.sleep(500); // Имитация работы
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}