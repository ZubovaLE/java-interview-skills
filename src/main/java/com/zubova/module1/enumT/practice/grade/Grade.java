package com.zubova.module1.enumT.practice.grade;

import java.util.Arrays;

public enum Grade {
    A(5), B(4), C(3), D(2), F(1);

    private final int value;

    Grade(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    /**
     * Проверяет, является ли оценка проходной (C или выше).
     *
     * @return true, если оценка проходная.
     */
    public boolean isPassing() {
        return this.value >= C.value;
    }

    /**
     * Вычисляет средний балл на основе массива оценок.
     *
     * @param grades Массив оценок.
     * @return Средний балл или 0.0, если массив пуст.
     * @throws IllegalArgumentException если массив null.
     */
    public static double calculateAverageGrade(Grade[] grades) {
        if (grades == null) {
            throw new IllegalArgumentException("Массив оценок не должен быть null");
        }
        if (grades.length == 0) {
            return 0.0;
        }

        return Arrays.stream(grades)
                .mapToDouble(Grade::getValue)
                .average()
                .orElse(0.0);
    }
}