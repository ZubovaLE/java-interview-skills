package com.zubova.module1.multithreading.example.threadlocal;

public class ThreadLocalExampleOne {
    private static ThreadLocal<Integer> threadLocalValue = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        // Создаем два потока
        Thread thread1 = new Thread(() -> {
            threadLocalValue.set(10);
            System.out.println("Thread 1 value: " + threadLocalValue.get());
        });

        Thread thread2 = new Thread(() -> {
            threadLocalValue.set(20);
            System.out.println("Thread 2 value: " + threadLocalValue.get());
        });

        thread1.start(); // Запускаем первый поток
        thread2.start(); // Запускаем второй поток
    }
}