package com.zubova.module1.serialization.practice.second;


public class Demo {

    public static void main(String[] args) {
        CustomStudent student = new CustomStudent("Ivanov", "Ivan", "-", "3456");
        CustomStudentSerialization serialization = new CustomStudentSerialization();
        serialization.serialize(student, "customStudent.ser");
        CustomStudent desStudent = serialization.deserialize("customStudent.ser");
        System.out.println(desStudent.getName());
        System.out.println(desStudent.getLastname());
        System.out.println(desStudent.getSurname());
        System.out.println(desStudent.getConfirmationCode());
    }
}
