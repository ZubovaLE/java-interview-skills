package com.zubova.module1.interfaces.practice.smart;

public class Lamp implements SmartDevice, Controllable {

    private static final int OFF_STATE_CONST = 0;
    private static final int ON_STATE_CONST = 1;
    private int onState = 0;

    @Override
    public void turnOn() {
        setValue(ON_STATE_CONST);
        System.out.println("The lamp is turned on");
    }

    @Override
    public void turnOff() {
        setValue(OFF_STATE_CONST);
        System.out.println("The lamp is turned on");
    }

    @Override
    public boolean isOn() {
        return onState == ON_STATE_CONST;
    }

    @Override
    public void setValue(int value) {
        this.onState = value;
    }

    @Override
    public int getValue() {
        return onState;
    }

}