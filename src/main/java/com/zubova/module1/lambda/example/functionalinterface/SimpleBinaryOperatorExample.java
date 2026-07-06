package com.zubova.module1.lambda.example.functionalinterface;

import java.util.function.BinaryOperator;

public class SimpleBinaryOperatorExample {
    public static void main(String[] args) {
        // Создаём BinaryOperator который складывает два числа
        BinaryOperator<Integer> sum = (a, b) -> a + b;

        // Используем его разными способами
        System.out.println("2 + 3 = " + sum.apply(2, 3));     // выведет: 2 + 3 = 5
        System.out.println("10 + 5 = " + sum.apply(10, 5));   // выведет: 10 + 5 = 15

        // Можно создать BinaryOperator для умножения
        BinaryOperator<Integer> multiply = (a, b) -> a * b;

        System.out.println("4 * 6 = " + multiply.apply(4, 6));  // выведет: 4 * 6 = 24
    }
}