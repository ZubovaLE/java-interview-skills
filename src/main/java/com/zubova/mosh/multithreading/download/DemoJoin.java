package com.zubova.mosh.multithreading.download;

public class DemoJoin {
    public static void main(String[] args) {
        Thread thread = new Thread(new DownLoadFileTask());
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("File is ready to be scanned");
    }
}
