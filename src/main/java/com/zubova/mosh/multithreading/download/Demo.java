package com.zubova.mosh.multithreading.download;

public class Demo {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            new Thread(new DownLoadFileTask()).start();
        }
    }
}
