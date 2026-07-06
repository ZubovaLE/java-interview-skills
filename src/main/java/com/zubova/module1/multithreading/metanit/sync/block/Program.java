package com.zubova.module1.multithreading.metanit.sync.block;

public class Program {

    public static void main(String[] args) {
        CommonResource commonResource = new CommonResource();
        for (int i = 1; i < 6; i++) {
            new Thread(new CountThread(commonResource), "Thread " + i).start();
        }
    }
}