package com.zubova.module1.multithreading.practice.arraysum;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[] array = createRandomArray(10_000_000);

        performSingleSolution(array);
        performMultiThreadSolution(array);
        performArraysParallelStreamSolution(array);

        performSingleSolution(array);
        performMultiThreadSolution(array);
        performArraysParallelStreamSolution(array);
    }

    private static void performSingleSolution(int[] array) {
        System.out.println("Single thread solution:");

        long start = System.currentTimeMillis();
        long singleThreadSum = singleThreadSum(array);
        long singleThreadTime = System.currentTimeMillis() - start;

        System.out.println("Single thread sum: " + singleThreadSum);
        System.out.println("Single thread time: " + singleThreadTime + " ms");
    }

    private static void performMultiThreadSolution(int[] array) {
        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of available processors: " + processors);
        try (ForkJoinPool forkJoinPool = new ForkJoinPool(processors)) {
            System.out.println("Multi thread solution:");
            ArraySumCalculator task = new ArraySumCalculator(array);

            long startTimeParallel = System.currentTimeMillis();
            long parallelSum = forkJoinPool.invoke(task);
            long parallelTime = System.currentTimeMillis() - startTimeParallel;

            System.out.println("Parallel sum: " + parallelSum);
            System.out.println("Parallel time: " + parallelTime + " ms");
        }
    }

    private static void performArraysParallelStreamSolution(int[] array) {
        System.out.println("Arrays parallel stream solution:");

        long start = System.currentTimeMillis();
        long sum = Arrays.stream(array).asLongStream().parallel().sum();
        long time = System.currentTimeMillis() - start;

        System.out.println("Arrays parallel stream sum: " + sum);
        System.out.println("Arrays parallel stream time: " + time + " ms");
    }

    private static int[] createRandomArray(int length) {
        Random random = new Random();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(10);
        }
        return array;
    }

    private static long singleThreadSum(int[] array) {
        long sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }

}
