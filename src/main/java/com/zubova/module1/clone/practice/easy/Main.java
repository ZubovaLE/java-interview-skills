package com.zubova.module1.clone.practice.easy;

public class Main {

    public static void main(String[] args) {
        Person person = new Person("one", 32);
        System.out.println("Person name: " + person.getName());
        System.out.println("Person age: " + person.getAge());
        try {
            Person clonedPerson = person.clone();
            System.out.println("\nClone before updating:");
            System.out.println("Clone name: " + clonedPerson.getName());
            System.out.println("Clone age: " + clonedPerson.getAge());
            clonedPerson.setName("new");
            clonedPerson.setAge(27);
            System.out.println("\nClone after updating:");
            System.out.println("Clone name: " + clonedPerson.getName());
            System.out.println("Clone age: " + clonedPerson.getAge());
            System.out.println("\nPerson after clone updating:");
            System.out.println("Person name: " + person.getName());
            System.out.println("Person age: " + person.getAge());
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning failed for Person", e);
        }
    }
}
