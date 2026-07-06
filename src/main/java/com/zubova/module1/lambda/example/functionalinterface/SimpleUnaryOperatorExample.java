package com.zubova.module1.lambda.example.functionalinterface;

import java.util.function.UnaryOperator;

public class SimpleUnaryOperatorExample {
    public static void main(String[] args) {
        // Создаём UnaryOperator который умножает число на 2
        UnaryOperator<Integer> doubleNumber = x -> x * 2;

        // Используем его
        System.out.println("5 * 2 = " + doubleNumber.apply(5));     // выведет: 5 * 2 = 10
        System.out.println("10 * 2 = " + doubleNumber.apply(10));   // выведет: 10 * 2 = 20

        // Можно создать UnaryOperator для возведения в квадрат
        UnaryOperator<Integer> square = x -> x * x;

        System.out.println("3 в квадрате = " + square.apply(3));    // выведет: 3 в квадрате = 9
        System.out.println("4 в квадрате = " + square.apply(4));    // выведет: 4 в квадрате = 16
    }
}