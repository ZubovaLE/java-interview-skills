package com.zubova.module1.initialization.practice.three;

import java.util.Arrays;
import java.util.Comparator;

public final class ArrayUtils {

    private ArrayUtils() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static <T> T findMax(T[] array, Comparator<? super T> comparator) {
        validateArray(array);
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (comparator.compare(max, array[i]) < 0) {
                max = array[i];
            }
        }
        return max;
    }

    public static <T> void sort(T[] array, Comparator<? super T> comparator) {
        validateArray(array);
        Arrays.sort(array, comparator);
    }

    public static <T> boolean isSorted(T[] array, Comparator<? super T> comparator) {
        validateArray(array);
        for (int i = 0; i < array.length - 1; i++) {
            if (comparator.compare(array[i], array[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    private static <T> void validateArray(T[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }
    }

}