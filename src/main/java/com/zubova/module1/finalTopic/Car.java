package com.zubova.module1.finalTopic;

public class Car {

    private CarType carType;

    public final CarType getType() {
        return carType;
    }

    public enum CarType {

        SEDAN,
        CROSSOVER

    }

}
