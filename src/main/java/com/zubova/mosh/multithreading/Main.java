package com.zubova.mosh.multithreading;

public class Main {
    public static void main(String[] args) {
        System.out.println(Thread.activeCount());
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
