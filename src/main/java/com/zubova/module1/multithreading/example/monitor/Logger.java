package com.zubova.module1.multithreading.example.monitor;

public class Logger {
    private static final Object lock = new Object();

    public static void log(String message) {
        synchronized (lock) {
            // Simulate writing to a log file
            System.out.println("Logging: " + message);
            // Additional code to write to the log file goes here
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> Logger.log("Message from Thread 1"));
        Thread thread2 = new Thread(() -> Logger.log("Message from Thread 2"));

        thread1.start();
        thread2.start();
    }
}
