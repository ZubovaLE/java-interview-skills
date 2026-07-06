package com.zubova.module1.multithreading.metanit.third;

public class Program {

    public static void main(String[] args) {
        System.out.println("Main thread started...");

        Thread[] tasks = new Thread[4];
        for (int i = 0; i < tasks.length; i++) {
            tasks[i] = new Thread(new MyTask(), "MyTask_" + i);
            tasks[i].start();
            try {
                tasks[i].join();
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
        System.out.println("Main thread finished...");
    }
}