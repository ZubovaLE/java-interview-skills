package com.zubova.module1.multithreading.metanit.threadsarray;

public class Program {

    public static void main(String[] args) {
        System.out.println("Main thread started...");
        for (int i = 1; i < 6; i++) {
            var task = new MyTask();
            new Thread(task, "MyTask_" + i).start();
        }
        System.out.println("Main thread finished...");
    }
}