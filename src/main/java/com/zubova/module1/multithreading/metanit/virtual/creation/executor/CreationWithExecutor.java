package com.zubova.module1.multithreading.metanit.virtual.creation.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CreationWithExecutor {

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            executorService.execute(() -> System.out.println("Hello from virtual thread created by Executor"));

            Future<String> future = executorService.submit(() -> {
                System.out.println("Hello!");
                return "result";
            });
        }
    }
}
