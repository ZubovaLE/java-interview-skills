package com.zubova.module1.lambda.example.requestprocessor;

public class WebApplication {
    public static void main(String[] args) {
        RequestProcessor processor = getProcessor("GET");
        String result = processor.process("/users");
        System.out.println(result); // "Processing GET request: /users"

        System.out.println(getProcessor("POST")
            .process("/data")); // "Processing POST request: /data"
    }

    private static RequestProcessor getProcessor(String method) {
        switch(method) {
            case "GET":
                return (req) -> "Processing GET request: " + req;
            case "POST":
                return (req) -> "Processing POST request: " + req;
            case "PUT":
                return (req) -> "Processing PUT request: " + req;
            default:
                return (req) -> "Unknown method for: " + req;
        }
    }
}