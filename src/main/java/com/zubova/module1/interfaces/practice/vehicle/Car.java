package com.zubova.module1.interfaces.practice.vehicle;

public class Car extends Vehicle{

    @Override
    void startEngine() {
        System.out.println("Car is started");
    }

    @Override
    void stopEngine() {
        System.out.println("Car is stopped");
    }

}