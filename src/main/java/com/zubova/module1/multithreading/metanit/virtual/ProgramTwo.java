package com.zubova.module1.multithreading.metanit.virtual;

class ProgramTwo {

    public static void main(String[] args) {
        System.out.println("Main thread started...");

        Runnable task = () -> {
            System.out.println("Hello from " + Thread.currentThread().getName());
        };

        var t = Thread.ofVirtual()
                .name("MyTask")  // устанавливаем имя
                .start(task);     // запускаем поток
        try {
            t.join();       // ждем завершения виртуального потока
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        System.out.println("Main thread finished...");
    }
}