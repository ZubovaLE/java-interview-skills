package com.zubova.module1.interfaces.practice.vehicle;

public class Motorcycle extends Vehicle {

    @Override
    void startEngine() {
        System.out.println("Moto is started");
    }

    @Override
    void stopEngine() {
        System.out.println("Moto is stopped");
    }

}