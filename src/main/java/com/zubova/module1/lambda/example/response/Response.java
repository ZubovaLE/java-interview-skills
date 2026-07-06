package com.zubova.module1.lambda.example.response;

public class Response {
    private int status;
    private String message;

    Response(int status, String message) {
        this.status = status;
        this.message = message;
    }

    int getStatus() { return status; }
}