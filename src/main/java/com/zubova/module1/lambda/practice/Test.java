package com.zubova.module1.lambda.practice;

public interface Test {
    void apply(String s);

    static void print() {
        System.out.println("Hello");
    }

    default void printDefault(){
        System.out.println("Default");
    }
}
