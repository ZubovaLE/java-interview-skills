package com.zubova.module1.multithreading.example.threadlocal;

public class ThreadLocalExample {

    // Создаем ThreadLocal переменную для хранения идентификатора пользователя
    private static ThreadLocal<Integer> userId = ThreadLocal.withInitial(() -> null);

    public static void main(String[] args) {
        // Создаем и запускаем несколько потоков
        Thread thread1 = new Thread(() -> {
            userId.set(1); // Устанавливаем значение для потока 1
            System.out.println("Thread 1 User ID: " + userId.get());
        });

        Thread thread2 = new Thread(() -> {
            userId.set(2); // Устанавливаем значение для потока 2
            System.out.println("Thread 2 User ID: " + userId.get());
        });

        // Запускаем потоки
        thread1.start();
        thread2.start();

        // Ждем завершения потоков
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Печатаем значение в основном потоке (будет null, если не установлено)
        System.out.println("Main Thread User ID: " + userId.get()); // Выведет null
    }
}