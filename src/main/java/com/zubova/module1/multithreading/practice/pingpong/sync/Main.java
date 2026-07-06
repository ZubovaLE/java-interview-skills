package com.zubova.module1.multithreading.practice.pingpong.sync;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        PingPong game = new PingPong(5);

        Thread pingThread = new Thread(() -> {
            try {
                game.playPing();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread pongThread = new Thread(() -> {
            try {
                game.playPong();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        pingThread.start();
        pongThread.start();

        pingThread.join();
        pongThread.join();

        System.out.println("Game finished.");
    }

}