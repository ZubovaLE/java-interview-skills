package com.zubova.module1.multithreading.example.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private final ReentrantLock lock = new ReentrantLock();
    private int count = 0;

    public void increment() {
        lock.lock(); // Захватываем блокировку
        try {
            count++;
        } finally {
            lock.unlock(); // Обязательно освобождаем блокировку
        }
    }

    public int getCount() {
        return count;
    }
}