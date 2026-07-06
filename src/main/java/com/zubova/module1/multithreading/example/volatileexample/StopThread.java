package com.zubova.module1.multithreading.example.volatileexample;

public class StopThread {
    private volatile boolean stopped = false;

    public void run() {
        while (!stopped) {
            // Выполнение работы
        }
    }

    public void stop() {
        stopped = true;
    }
}