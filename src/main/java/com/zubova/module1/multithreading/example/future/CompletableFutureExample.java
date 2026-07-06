package com.zubova.module1.multithreading.example.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture
                .supplyAsync(() -> "Привет")
                .thenApply(s -> s + ", мир!")
                .thenApply(String::toUpperCase);

        try {
            String result = future.get();
            System.out.println(result);// "ПРИВЕТ, МИР!"
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
