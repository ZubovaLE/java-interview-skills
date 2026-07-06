package com.zubova.module1.lambda.example.functionalinterface;

import java.util.function.Supplier;
import java.util.UUID;

public class ConfigExample {
    public static void main(String[] args) {
        Supplier<ServerConfig> configFactory = () -> {
            ServerConfig config = new ServerConfig();
            config.setId(UUID.randomUUID().toString());
            config.setPort(8080);
            config.setThreads(Runtime.getRuntime().availableProcessors());
            return config;
        };

        ServerConfig config = configFactory.get();
        System.out.println("Server ID: " + config.getId());
        System.out.println("Port: " + config.getPort());
        System.out.println("Port: " + config.getThreads());
    }
}