package com.zubova.module1.multithreading.example.forkjoinpool;

import java.math.BigInteger;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinExample {

    public static void main(String[] args) {

        final int numberOfProcessors = Runtime.getRuntime().availableProcessors();
        final ForkJoinPool forkJoinPool = new ForkJoinPool(numberOfProcessors);

        final ForkJoinTask<BigInteger> result = forkJoinPool.submit(new Fibonacci(30));

        System.out.println("The result is : " + result.join());
    }

    static class Fibonacci extends RecursiveTask<BigInteger> {

        private final int number;

        public Fibonacci(int number) {
            this.number = number;
        }

        @Override
        protected BigInteger compute() {
            if (number <= 1) {
                return BigInteger.valueOf(number);
            } else {
                Fibonacci fibonacciMinus1 = new Fibonacci(number - 1);
                Fibonacci fibonacciMinus2 = new Fibonacci(number - 2);
                fibonacciMinus1.fork();
                return fibonacciMinus2.compute().add(fibonacciMinus1.join());
            }
        }
    }
}