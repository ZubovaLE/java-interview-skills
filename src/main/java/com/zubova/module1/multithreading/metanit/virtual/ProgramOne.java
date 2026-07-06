package com.zubova.module1.multithreading.metanit.virtual;

class ProgramOne {

    public static void main(String[] args) {
        System.out.println("Main thread started...");

        Runnable task = () -> {
            System.out.println("Hello from a virtual thread");
        };

        Thread thread = Thread.startVirtualThread(task);// запускаем виртуальный поток

        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Main thread finished...");
    }
}