package com.zubova.module1.object.example.one;

import java.util.HashMap;

public class EqualsHashCodeExample {
    public static void main(String[] args) {
        // Создаем двух студентов с одинаковыми данными
        Student student1 = new Student("Иван", 20, "ST001");
        Student student2 = new Student("Иван", 20, "ST001");

        // Проверяем equals()
        System.out.println("Равны ли студенты? " + student1.equals(student2)); // true

        // Проверяем hashCode()
        System.out.println("Хеш-коды равны? " +
                (student1.hashCode() == student2.hashCode())); // true

        // Использование в HashMap
        HashMap<Student, String> studentMap = new HashMap<>();
        studentMap.put(student1, "Группа А");

        // Можем найти информацию по student2, так как equals() и hashCode()
        // правильно переопределены
        System.out.println("Группа: " + studentMap.get(student2)); // "Группа А"
    }
}