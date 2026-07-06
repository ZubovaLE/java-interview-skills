package com.zubova.module1.multithreading.metanit.interrupt;

class MyTask implements Runnable {

    public void run() {
        String name = Thread.currentThread().getName();
        try {
            System.out.println(name + " started...");
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(name + " works");
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(name + " finished...");
    }
} 