package com.zubova.module1.multithreading.example.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(() -> {
            Thread.sleep(1000);
            return 42;
        });

// Делаем другую работу пока задача выполняется
        System.out.println("Ожидаем результат...");

// Блокируемся и ждем результата
        int result = 0;  // Блокирующая операция
        try {
            result = future.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Результат: " + result);

        executor.shutdown();
    }
}
