package com.zubova.module1.multithreading.practice.pingpong.sync;

public class PingPong {

    private final Object monitor = new Object();
    private volatile boolean isPingTurn = true;
    private final int maxIterations;

    public PingPong(int maxIterations) {
        this.maxIterations = maxIterations;
    }

    public void playPing() throws InterruptedException {
        for (int i = 0; i < maxIterations; i++) {
            synchronized (monitor) {
                while (!isPingTurn) {
                    monitor.wait();
                }
                System.out.println("ping");
                isPingTurn = false;
                monitor.notifyAll();
            }
        }
    }

    public void playPong() throws InterruptedException {
        for (int i = 0; i < maxIterations; i++) {
            synchronized (monitor) {
                while (isPingTurn) {
                    monitor.wait();
                }
                System.out.println("pong");
                isPingTurn = true;
                monitor.notifyAll();
            }
        }
    }

}