package com.zubova.module1.lambda.example.functionalinterface;

import java.util.function.Function;

public class DataTransformExample {
    public static void main(String[] args) {
        Function<User, String> toJson = user ->
            String.format("{\"id\": %d, \"name\": \"%s\"}",
                user.getId(), user.getName());

        User user = new User(1, "John");
        System.out.println(toJson.apply(user));
        // {"id": 1, "name": "John"}
    }
}