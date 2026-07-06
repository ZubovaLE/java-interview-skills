package com.zubova.module1.multithreading.metanit.virtual.creation.fabric;

import java.util.concurrent.ThreadFactory;

public class CreationWithFabric {

    public static void main(String[] args) {
        Thread.Builder.OfVirtual builder = Thread.ofVirtual();
        ThreadFactory threadFactory = builder.factory();
        Thread threadFromFabric = threadFactory.newThread(() -> System.out.println("Fabric"));
        threadFromFabric.start();
    }
}
