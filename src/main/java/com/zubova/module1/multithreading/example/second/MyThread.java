package com.zubova.module1.multithreading.example.second;

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("run() выполняется в потоке: " + Thread.currentThread().getName());
    }
}