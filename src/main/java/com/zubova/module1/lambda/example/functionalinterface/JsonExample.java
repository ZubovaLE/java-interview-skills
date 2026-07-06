package com.zubova.module1.lambda.example.functionalinterface;

import java.util.function.UnaryOperator;

public class JsonExample {
    public static void main(String[] args) {
        UnaryOperator<String> addTimestamp = json ->
            json.replace("}", ", \"timestamp\": " +
            System.currentTimeMillis() + "}");

        String result = addTimestamp.apply("{\"status\": \"success\"}");
        System.out.println(result);
        // {"status": "success", "timestamp": 1676234567890}
    }
}
