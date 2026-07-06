package com.zubova.module1.multithreading.practice.arraysum;

import java.util.concurrent.RecursiveTask;

public class ArraySumCalculator extends RecursiveTask<Long> {

    private static final int THRESHOLD = 10_000;
    private final int[] array;
    private final int start;
    private final int end;

    public ArraySumCalculator(int[] array) {
        this(array, 0, array.length);
    }

    public ArraySumCalculator(int[] array, int start, int end) {
        if (array == null) {
            throw new IllegalArgumentException();
        }
        this.array = array;
        if (start > end) {
            throw new IllegalArgumentException();
        }
        if (end > array.length) {
            throw new IllegalArgumentException();
        }
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD) {
            return computeSequentially();
        }
        int mid = length / 2 + start;
        ArraySumCalculator leftTask = new ArraySumCalculator(array, start, mid);
        ArraySumCalculator rightTask = new ArraySumCalculator(array, mid, end);
        leftTask.fork();
        return rightTask.compute() + leftTask.join();
    }

    private long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
        return sum;
    }

}