package com.zubova.module1.exception.practice.easy;

import java.util.logging.Logger;

public class SafeCalculator {
    private static final Logger LOGGER = Logger.getLogger(SafeCalculator.class.getName());

    public static int divide(int a, int b) {
        try {
            if (b == 0) {
                throw new ArithmeticException("The second operand cannot be 0");
            }
            if (a == Integer.MAX_VALUE && b == -1) {
                throw new ArithmeticException("Too large result");
            }
            return a / b;
        } catch (ArithmeticException e) {
            LOGGER.severe("Operation error: " + e.getMessage());
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(divide(10, 2));   // Корректное деление
        System.out.println(divide(10, 0));   // Деление на ноль
        System.out.println(divide(Integer.MIN_VALUE, -1));  // Переполнение
    }
}