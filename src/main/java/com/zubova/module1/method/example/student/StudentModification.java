package com.zubova.module1.method.example.student;

public class StudentModification {
    // Метод для попытки изменения возраста (примитивный тип)
    public void modifyAge(int age) {
        age = age + 1;
    }

    // Метод для изменения массива оценок (ссылочный тип)
    public void modifyGrades(int[] grades) {
        for (int i = 0; i < grades.length; i++) {
            grades[i] = grades[i] + 1;
        }
    }

    // Метод для изменения данных студента (ссылочный тип - объект)
    public void modifyStudent(Student student) {
        student.name = student.name + " (modified)";
        student.age = student.age + 1;
    }

    public static void main(String[] args) {
        StudentModification modifier = new StudentModification();

        // Создаем данные студента
        int studentAge = 20;
        int[] studentGrades = {80, 85, 90};
        Student student = new Student("Иван", 20, studentGrades);

        // Пытаемся изменить возраст через метод
        System.out.println("Возраст до: " + studentAge); //20
        modifier.modifyAge(studentAge);
        System.out.println("Возраст после: " + studentAge); //20

        // Изменяем оценки
        System.out.println("\nОценки до:");
        for (int grade : student.grades) {
            System.out.print(grade + " ");
        }

        modifier.modifyGrades(student.grades);

        System.out.println("\nОценки после:");
        for (int grade : student.grades) {
            System.out.print(grade + " "); // изменятся на 1
        }

        // Изменяем данные студента
        System.out.println("\n\nСтудент до:");
        System.out.println("Имя: " + student.name + ", Возраст: " + student.age);

        modifier.modifyStudent(student);

        System.out.println("Студент после:");
        System.out.println("Имя: " + student.name + ", Возраст: " + student.age);
    }
}