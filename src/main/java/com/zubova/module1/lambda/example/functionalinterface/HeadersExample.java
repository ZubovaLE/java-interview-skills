package com.zubova.module1.lambda.example.functionalinterface;

import java.util.function.BinaryOperator;

public class HeadersExample {
    public static void main(String[] args) {
        BinaryOperator<String> combineHeaders = (header1, header2) ->
            header1 + "; " + header2;

        String result = combineHeaders.apply(
            "Content-Type: application/json",
            "Authorization: Bearer token123"
        );
        System.out.println(result);
        // Content-Type: application/json; Authorization: Bearer token123
    }
}