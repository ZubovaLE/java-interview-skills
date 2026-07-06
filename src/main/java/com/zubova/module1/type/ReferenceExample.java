package com.zubova.module1.type;

public class ReferenceExample {
    static class Person {
        String name;
        Person(String name) {
            this.name = name;
        }
    }

    public void modifyArray(int[] arr) {
        arr[0] = 100;
    }

    public void modifyPerson(Person person) {
        person.name = "Новое имя";
    }

    public void reassignReference(Person person) {
        person = new Person("Другой человек");
    }

    public static void main(String[] args) {
        ReferenceExample example = new ReferenceExample();

        int[] numbers = {1, 2, 3};
        System.out.println("До изменения массива: " + numbers[0]);    // 1
        example.modifyArray(numbers);
        System.out.println("После изменения массива: " + numbers[0]); // 100

        // Пример с объектом
        Person person = new Person("Иван");
        System.out.println("До изменения имени: " + person.name);     // Иван
        example.modifyPerson(person);
        System.out.println("После изменения имени: " + person.name);  // Новое имя

        // Пример с переназначением ссылки
        Person person2 = new Person("Мария");
        System.out.println("До переназначения: " + person2.name);     // Мария
        example.reassignReference(person2);
        System.out.println("После переназначения: " + person2.name);  // Мария (не изменилось!)
    }
}