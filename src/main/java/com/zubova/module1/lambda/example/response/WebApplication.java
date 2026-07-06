package com.zubova.module1.lambda.example.response;

public class WebApplication {
    public static void main(String[] args) {
        ResponseBuilder builder = Response::new;
        Response response = builder.create(200, "OK");
        System.out.println(response.getStatus()); // 200
    }
}