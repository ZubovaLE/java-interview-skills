package com.zubova.module1.lambda.example.textformatter;

public class TextProcessor {
    public static void main(String[] args) {
        TextFormatter formatter;
        formatter = (text) -> text.toUpperCase();

        String result = formatter.format("hello web developer");
        System.out.println(result); // HELLO WEB DEVELOPER
    }
}