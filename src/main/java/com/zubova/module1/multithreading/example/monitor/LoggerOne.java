package com.zubova.module1.multithreading.example.monitor;

class LoggerOne {
    private static StringBuilder logText = new StringBuilder();

    public static synchronized void log(String message) {
        logText.append(message).append("\n");
        System.out.println("Лог: " + message);
    }
}