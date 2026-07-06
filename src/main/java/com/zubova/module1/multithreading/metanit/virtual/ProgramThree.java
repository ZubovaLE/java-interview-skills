package com.zubova.module1.multithreading.metanit.virtual;

class ProgramThree {

    public static void main(String[] args) {
        System.out.println("Main thread started...");

        var t = Thread.ofVirtual()
                .name("MyTask")  // устанавливаем имя
                .unstarted(() -> System.out.println("Hello from " + Thread.currentThread().getName()));

        t.start();     // запускаем поток
        try {
            t.join();       // ждем завершения виртуального потока
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        System.out.println("Main thread finished...");
    }
}