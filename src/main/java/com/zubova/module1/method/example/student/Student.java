package com.zubova.module1.method.example.student;

class Student {
    String name;
    int age;
    int[] grades;     // массив оценок

    public Student(String name, int age, int[] grades) {
        this.name = name;
        this.age = age;
        this.grades = grades;
    }
}