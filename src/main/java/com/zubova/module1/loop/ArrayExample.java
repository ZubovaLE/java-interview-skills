package com.zubova.module1.loop;

import java.util.Arrays;

public class ArrayExample {

    public static void main(String[] args) {
        System.out.println(getSum(new int[]{1, 2, 3, 4}));
        System.out.println(getSumWithStream(new int[]{1, 2, 3, 4}));

        System.out.println(getMaxSubArraySum(new int[]{2, 3, -8, 7, -1, 2, 3}));

        // Kadane
        int[] arr = {2, 3, -8, 7, -1, 2, 3};
        System.out.println(findMaxSubarraySum(arr));
    }

    private static int getSum(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        return sum;
    }

    private static int getSumWithStream(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        return Arrays.stream(array).sum();
    }
    // bad (o(n^3))
    private static int getMaxSubArraySum(int[] array) {
        int maxSum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length; j > i; j--) {
                int subArraySum = getSum(Arrays.copyOfRange(array, i, j));
                if (subArraySum > maxSum) {
                    maxSum = subArraySum;
                }
            }
        }
        return maxSum;
    }

    /**
     * Находит максимальную сумму непрерывного подмассива, используя алгоритм Кадане.
     *
     * @param nums Массив целых чисел.
     * @return Максимальная сумма подмассива.
     */
    public static int findMaxSubarraySum(int[] nums) {
        // Проверка на граничные случаи для надежности кода
        if (nums == null || nums.length == 0) {
            // В зависимости от требований, можно выбросить исключение или вернуть 0
            throw new IllegalArgumentException("Входной массив не должен быть null или пустым");
        }

        // Инициализируем обе переменные первым элементом массива.
        // Это корректно обрабатывает случай с массивом из одного элемента
        // и массивами, содержащими только отрицательные числа.
        int currentMaxSum = nums[0]; // Максимальная сумма подмассива, заканчивающегося на текущем элементе
        int globalMaxSum = nums[0];  // Максимальная сумма, найденная на данный момент

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            // Для текущего элемента мы выбираем:
            // 1. Начать новый подмассив (взять только текущий элемент `num`).
            // 2. Или продолжить старый (добавить `num` к `currentMaxSum`).
            currentMaxSum = Math.max(num, currentMaxSum + num);

            // Обновляем глобальный максимум, если текущий максимум его превзошел.
            globalMaxSum = Math.max(globalMaxSum, currentMaxSum);
        }

        return globalMaxSum;
    }

}