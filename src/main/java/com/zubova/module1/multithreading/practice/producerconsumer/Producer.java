package com.zubova.module1.multithreading.practice.producerconsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private final BlockingQueue<Integer> queue;
    private final String name;
    private final Random random = new Random();

    public Producer(BlockingQueue<Integer> queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                int number = random.nextInt(100);
                queue.put(number);
                System.out.printf("%s produced %d. Queue size: %d%n", name, number, queue.size());
                Thread.sleep(100); // Имитация работы
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}