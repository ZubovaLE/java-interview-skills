package com.zubova.module1.multithreading.metanit.first;

import java.util.Arrays;
import java.util.Map;

public class Program {

    public static void main(String[] args) {

        // получаем только потоки без трасировки стека
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        var threads = allStackTraces.keySet();

        for (var thread : threads) {
            System.out.println(thread);
            System.out.println(Arrays.toString(allStackTraces.get(thread)));
        }
    }
}