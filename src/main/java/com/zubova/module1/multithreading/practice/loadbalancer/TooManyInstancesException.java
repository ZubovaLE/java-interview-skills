package com.zubova.module1.multithreading.practice.loadbalancer;

public class TooManyInstancesException extends Exception {

    public TooManyInstancesException(String message) {
        super(message);
    }

}
