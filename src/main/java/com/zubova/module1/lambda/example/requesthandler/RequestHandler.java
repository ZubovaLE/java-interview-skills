package com.zubova.module1.lambda.example.requesthandler;

public class RequestHandler {
    public static void main(String[] args) {
        String[] requests = {
                "GET /users?api_key=123",
                "POST /data",
                "GET /status?api_key=456",
                "DELETE /user/1"
        };

        System.out.println(processRequests(requests, req -> req.contains("api_key")));
        System.out.println(processRequests(requests, req -> req.startsWith("GET")));
    }

    private static int processRequests(String[] requests, Validator validator) {
        int validRequests = 0;
        for(String req : requests) {
            if (validator.isValid(req))
                validRequests++;
        }
        return validRequests;
    }
}