package com.zubova.module1.multithreading.example.threadpoolexecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExample {
    public static void main(String[] args) {
        // Создание пула с 4 потоками — типичное решение для компьютеров с 4 ядрами
        ExecutorService executor = Executors.newFixedThreadPool(4);

// Подача задачи на исполнение
        executor.execute(() -> {
            System.out.println("Задача выполняется в потоке: " + Thread.currentThread().getName());
        });
    }
}
