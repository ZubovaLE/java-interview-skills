package com.zubova.module1.multithreading.example.readwritelock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {
    ReadWriteLock lock = new ReentrantReadWriteLock();
    Lock readLock = lock.readLock();
    Lock writeLock = lock.writeLock();

    public void readData() {
        readLock.lock();
        try {
            // действия чтения
        } finally {
            readLock.unlock();
        }
    }

    public void writeData() {
        writeLock.lock();
        try {
            // действия записи
        } finally {
            writeLock.unlock();
        }
    }
}
