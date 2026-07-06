package com.zubova.module1.serialization.practice.third;

import com.zubova.module1.serialization.practice.first.Student;

public class Demo {

    public static void main(String[] args) {
        Student student = new Student("Ivanov", "Ivan", "-", Student.Specialty.IT);
        JsonSerialization serialization = new JsonSerialization();
        String json = serialization.serializeToJson(student);
        System.out.println(json);
        Student desStudent = serialization.deserializeFromJson(json);
        System.out.println(desStudent.getName());
        System.out.println(desStudent.getLastname());
        System.out.println(desStudent.getSurname());
        System.out.println(desStudent.getSpecialty());
    }
}
