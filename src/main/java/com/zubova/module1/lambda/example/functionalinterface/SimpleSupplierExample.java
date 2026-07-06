package com.zubova.module1.lambda.example.functionalinterface;

import java.util.function.Supplier;
import java.util.Random;
import java.time.LocalDateTime;

public class SimpleSupplierExample {
    public static void main(String[] args) {
        // Создаём Supplier который генерирует случайное число от 1 до 100
        Supplier<Integer> randomNumber = () -> new Random().nextInt(100) + 1;

        // Используем его
        System.out.println("Случайное число: " + randomNumber.get());  // например: 42
        System.out.println("Ещё случайное число: " + randomNumber.get());  // например: 73

        // Supplier который возвращает текущее время
        Supplier<String> currentTime = () -> LocalDateTime.now().toString();

        System.out.println("Текущее время: " + currentTime.get());

        // Supplier который генерирует случайный пароль
        Supplier<String> passwordGenerator = () -> {
            String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            StringBuilder password = new StringBuilder();
            Random random = new Random();

            for (int i = 0; i < 8; i++) {
                password.append(chars.charAt(random.nextInt(chars.length())));
            }

            return password.toString();
        };

        System.out.println("Новый пароль: " + passwordGenerator.get());  // например: "kJ9mP2nX"
        System.out.println("Другой пароль: " + passwordGenerator.get()); // например: "xY5nM8qL"
    }
}
