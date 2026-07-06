package com.zubova.module1.object.example.one;

import java.util.Objects;

public class Student {
    private final String name;
    private final int age;
    private final String studentId;

    // Конструктор
    public Student(String name, int age, String studentId) {
        this.name = name;
        this.age = age;
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        // 1. Проверка ссылок на один и тот же объект
        if (this == o) return true;

        // 2. Проверка на null и принадлежность к тому же классу
        if (o == null || getClass() != o.getClass()) return false;

        // 3. Приведение типа
        Student student = (Student) o;

        // 4. Сравнение всех значимых полей
        // Используем Objects.equals для корректного сравнения строк (защита от null)
        return age == student.age &&
               Objects.equals(name, student.name) &&
               Objects.equals(studentId, student.studentId);
    }

    @Override
    public int hashCode() {
        // Используем Objects.hash для вычисления хеш-кода
        // Включаем все поля, которые участвуют в equals()
        return Objects.hash(name, age, studentId);

        // Альтернативный вариант:
        // final int prime = 31;
        // int result = 1;
        // result = prime * result + age;
        // result = prime * result + (name == null ? 0 : name.hashCode());
        // result = prime * result + (studentId == null ? 0 : studentId.hashCode());
        // return result;
    }
}