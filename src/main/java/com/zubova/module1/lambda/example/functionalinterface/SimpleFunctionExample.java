package com.zubova.module1.lambda.example.functionalinterface;

import java.util.function.Function;

public class SimpleFunctionExample {
    public static void main(String[] args) {
        // Создаём Function которая преобразует число в строку с добавлением рублей
        Function<Integer, String> convertToRubles = x -> x + " рублей";

        // Используем её
        System.out.println(convertToRubles.apply(100));    // выведет: 100 рублей
        System.out.println(convertToRubles.apply(500));    // выведет: 500 рублей

        // Function для преобразования строки в её длину
        Function<String, Integer> getLength = str -> str.length();

        System.out.println("Длина слова 'Привет': " + getLength.apply("Привет"));    // выведет: 6
        System.out.println("Длина слова 'Java': " + getLength.apply("Java"));        // выведет: 4

        // Function для преобразования температуры из Цельсия в Фаренгейты
        Function<Integer, Double> celsiusToFahrenheit = c -> c * 1.8 + 32;

        System.out.println("0°C = " + celsiusToFahrenheit.apply(0) + "°F");     // выведет: 32.0°F
        System.out.println("20°C = " + celsiusToFahrenheit.apply(20) + "°F");   // выведет: 68.0°F
    }
}