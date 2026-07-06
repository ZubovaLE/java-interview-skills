package com.zubova.module1.multithreading.practice.tinyurl;

public class UnknownTinyUrlException extends RuntimeException {
    public UnknownTinyUrlException(String message) { super(message); }
}