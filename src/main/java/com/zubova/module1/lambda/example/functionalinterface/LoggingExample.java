package com.zubova.module1.lambda.example.functionalinterface;

import java.util.function.Consumer;

public class LoggingExample {
    public static void main(String[] args) {
        Consumer<String> requestLogger = request ->
            System.out.printf("[%d] Processing request: %s%n",
                System.currentTimeMillis(), request);

        requestLogger.accept("GET /api/users");
        // [1676234567890] Processing request: GET /api/users
    }
}