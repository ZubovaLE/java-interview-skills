package com.zubova.module1.interfaces.practice.smart;

public class CoffeeMachine implements SmartDevice, Controllable, Schedulable{

    @Override
    public void setValue(int value) {

    }

    @Override
    public int getValue() {
        return 0;
    }

    @Override
    public void setTimer(int minutes) {

    }

    @Override
    public void cancelTimer() {

    }

    @Override
    public void turnOn() {

    }

    @Override
    public void turnOff() {

    }

    @Override
    public boolean isOn() {
        return false;
    }

}