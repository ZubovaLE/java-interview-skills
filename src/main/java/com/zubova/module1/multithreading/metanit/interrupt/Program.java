package com.zubova.module1.multithreading.metanit.interrupt;

public class Program {

    public static void main(String[] args) {
        System.out.println("Main thread started...");
        var t = new Thread(new MyTask(), "MyTask");
        t.start();
        try {
            // делаем небольшую задержку, чтобы дочерний поток MyTask успел немного отработать
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        t.interrupt();
        System.out.println("Main thread finished...");
    }
}