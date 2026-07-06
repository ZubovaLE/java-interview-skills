package com.zubova.module1.multithreading.metanit.lock;

import java.util.concurrent.locks.ReentrantLock;

public class Program {

    public static void main(String[] args) {
        CommonResource commonResource = new CommonResource();
        ReentrantLock locker = new ReentrantLock();
        for (int i = 1; i < 6; i++) {
            new Thread(new CountThread(commonResource, locker), "Thread " + i).start();
        }
    }
}