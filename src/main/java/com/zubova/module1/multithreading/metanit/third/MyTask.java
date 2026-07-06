package com.zubova.module1.multithreading.metanit.third;

class MyTask implements Runnable {

    public void run(){
        String name = Thread.currentThread().getName();

        System.out.println(name + " started...");
        System.out.println(name + " works");

        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println(name + " finished...");
    }
} 