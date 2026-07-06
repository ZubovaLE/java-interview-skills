package com.zubova.module1.interfaces.practice.vehicle;

public abstract class Vehicle {

    abstract void startEngine();
    abstract void stopEngine();
    void showFuelLevel(){
        System.out.println("The level is good!");
    }

}