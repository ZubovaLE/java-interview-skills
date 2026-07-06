package com.zubova.module1.serialization.practice.first;

public class Demo {

    public static void main(String[] args) {
        Student student = new Student("Ivanov", "Ivan", "-", Student.Specialty.IT);
        StudentSerialization serialization = new StudentSerialization();
        serialization.serialize(student, "studentTrans.ser");
        Student deserializationStudent = serialization.deserialize("studentTrans.ser");
        System.out.println(deserializationStudent.getName());
        System.out.println(deserializationStudent.getLastname());
        System.out.println(deserializationStudent.getSurname());
        System.out.println(deserializationStudent.getSpecialty());
    }
}
