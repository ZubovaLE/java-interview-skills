package com.zubova.module1.object.example.three;

public class SharedResource {
    private boolean ready = false;

    public synchronized void produce() {
        ready = true;
        notify(); // Уведомить один ждущий поток
    }

    public synchronized void consume() throws InterruptedException {
        while (!ready) {
            wait(); // Ждать уведомления
        }
        ready = false;
    }
}