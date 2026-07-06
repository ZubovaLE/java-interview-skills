package com.zubova.module1.generic.practice.builder;

public class CarBuilder extends Builder<CarBuilder> {
    public CarBuilder setColor(String color) {
        return self();
    }

}