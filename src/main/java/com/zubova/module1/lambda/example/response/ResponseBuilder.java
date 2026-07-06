package com.zubova.module1.lambda.example.response;

public interface ResponseBuilder {
    Response create(int status, String message);
}