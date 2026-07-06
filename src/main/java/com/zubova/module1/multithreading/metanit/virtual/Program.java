package com.zubova.module1.multithreading.metanit.virtual;

class Program {

    public static void main(String[] args) {
        System.out.println("Main thread started...");

        Runnable task = () -> {
            Thread t = Thread.currentThread(); // получаем текущий поток

            System.out.println("Name: " + t.getName()); // если имя не задано, то t.getName() вернет пустую строку
            System.out.println("Is Vitual: " + t.isVirtual());
            System.out.println("Is Daemon: " + t.isDaemon());
            System.out.println("Priority: " + t.getPriority());
        };

        var thread = Thread.startVirtualThread(task);

        try {
            thread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        System.out.println("Main thread finished...");
    }
}