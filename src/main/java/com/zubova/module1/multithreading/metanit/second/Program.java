package com.zubova.module1.multithreading.metanit.second;

public class Program {
   
    public static void main(String[] args) {
        Thread t = Thread.currentThread();

        System.out.println("Id: " + t.threadId()); 
        System.out.println("Name: " + t.getName()); 
        System.out.println("Priority: " + t.getPriority()); 
        System.out.println("State: " + t.getState()); 
        System.out.println("isAlive: " + t.isAlive()); 
        System.out.println("isDaemon: " + t.isDaemon()); 
        System.out.println("isVirtual: " + t.isVirtual()); 
    }
}