package com.zubova.module1.multithreading.metanit.virtual;

import java.time.Instant;
import java.util.concurrent.CountDownLatch;

//Результат выполнения демонстрирует эффективное переключение контекста
public class Example {
    public static void main(String[] args) throws InterruptedException {
        int maxThreads = 3;
        CountDownLatch countDownLatch = new CountDownLatch(maxThreads);

        for (var i = 0; i < maxThreads; i++) {
            var j = i;
            Thread.ofVirtual().start(() -> {
                System.out.printf("%s Starting %d%n", Instant.now(), j);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                } finally {
                    countDownLatch.countDown();
                }
                System.out.printf("%s Completing %d%n", Instant.now(), j);
            });
        }
        countDownLatch.await();
    }
}
