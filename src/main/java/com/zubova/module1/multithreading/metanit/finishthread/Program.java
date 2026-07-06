package com.zubova.module1.multithreading.metanit.finishthread;

class Program {

    public static void main(String[] args) {
        System.out.println("Main thread started...");
        var myTask = new MyTask();
        new Thread(myTask, "MyTask").start();
        try {
            Thread.sleep(1100);
            myTask.disable();  // завершаем поток
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted...");
        }
        System.out.println("Main thread finished...");
    }
}