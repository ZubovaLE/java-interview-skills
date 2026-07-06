package com.zubova.module1.lambda.example.functionalinterface;

import java.util.function.Predicate;

public class ValidationExample {
    public static void main(String[] args) {
        Predicate<String> isValidEmail = email ->
            email != null && email.contains("@") && email.contains(".");

        System.out.println(isValidEmail.test("user@domain.com")); // true
        System.out.println(isValidEmail.test("invalid-email")); // false
    }
}