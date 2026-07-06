package com.zubova.module1.record.practice.simple;

public record Student(String name, int age) {

    public Student {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Invalid age!");
        }
    }
}