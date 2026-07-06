package com.zubova.module1.multithreading.metanit.virtual.creation.builder;

public class CreationWithBuilder {

    public static void main(String[] args) {
        Thread.Builder.OfVirtual builder = Thread.ofVirtual();
        builder.start(()-> System.out.println("I am a virtual thread!"));

        Thread.Builder.OfVirtual builder2 = Thread.ofVirtual();
        Thread vThread = builder2.unstarted(() -> System.out.println("Preset"));
        vThread.setName("With preset");
        vThread.start();

    }
}
