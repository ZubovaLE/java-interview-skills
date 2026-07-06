package com.zubova.module1.multithreading.example.mutex;

import java.util.concurrent.locks.ReentrantLock;

public class MutexExample {
    ReentrantLock lock = new ReentrantLock();

    public void doSomething() {
        lock.lock(); // Захватываем мьютекс
        try {
            // критическая секция - код, требующий защиты
        } finally {
            lock.unlock();  // Важно освободить замок даже при возникновении исключения. Освобождаем мьютекс
        }
    }
}
