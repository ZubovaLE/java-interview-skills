package com.zubova.module1.multithreading.practice.pingpong.lock;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@RequiredArgsConstructor
public class PingPongWithLock {

    private final Lock lock = new ReentrantLock();
    private final Condition pingCondition = lock.newCondition();
    private final Condition pongCondition = lock.newCondition();
    private boolean isPingTurn = true;
    private final int maxIterations;

    public void playPing() throws InterruptedException {
        for (int i = 0; i < maxIterations; i++) {
            lock.lock();
            try {
                while (!isPingTurn) {
                    pingCondition.await();
                }
                System.out.println("ping");
                isPingTurn = false;
                pongCondition.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void playPong() throws InterruptedException {
        for (int i = 0; i < maxIterations; i++) {
            lock.lock();
            try {
                while (isPingTurn) {
                    pongCondition.await();
                }
                System.out.println("Pong");
                isPingTurn = true;
                pingCondition.signal();
            } finally {
                lock.unlock();
            }
        }
    }

}
