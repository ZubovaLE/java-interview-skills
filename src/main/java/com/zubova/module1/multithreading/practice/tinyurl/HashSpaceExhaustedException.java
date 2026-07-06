package com.zubova.module1.multithreading.practice.tinyurl;

public class HashSpaceExhaustedException extends RuntimeException {
    public HashSpaceExhaustedException(String message) { super(message); }
}