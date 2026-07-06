package com.zubova.module1.multithreading.metanit.virtual.problem.threadpinning;

import java.time.Instant;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        for (var i = 0; i < 3; i++) {
            var j = i;
            Thread.ofVirtual().start(() -> {
                System.out.printf("%s Starting %d%n", Instant.now(), j);
                lock.lock();
                try {
                    condition.await(1000, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                } finally {
                    lock.unlock();
                    countDownLatch.countDown();
                }
                System.out.printf("%s Completing %d%n", Instant.now(), j);
            });
        }
        countDownLatch.await();
    }
}
