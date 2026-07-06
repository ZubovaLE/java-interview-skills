package com.zubova.module1.object.practice.person;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Person person = new Person("Petya", 23, List.of("One", "Two", "Three"));
        System.out.println("toString(): " + person);
        System.out.println("The first object hashcode: " + person.hashCode());
        System.out.println("The first object equals to itself: " + person.equals(person));
        System.out.println("The first object equals to itself (the second call): " + person.equals(person));
        System.out.println();
        Person person2 = new Person("Petya", 23, List.of("One", "Two", "Three"));
        System.out.println("toString(): " + person2);
        System.out.println("The second object hashcode: " + person2.hashCode());
        System.out.println("The first object equals to the second object: " + person.equals(person2));
        System.out.println("The second object equals to the first object (symmetrical): " + person2.equals(person));
        System.out.println();
        Person person3 = new Person("Petya", 23, List.of("One", "Two", "Three"));
        System.out.println("toString(): " + person3);
        System.out.println("The third object hashcode: " + person3.hashCode());
        System.out.println("The second object equals to the third object: " + person2.equals(person3));
        System.out.println("The first object equals to the third object: " + person.equals(person3));
        System.out.println();
        System.out.println("The first object equals to null: " + person.equals(null));
        System.out.println();
        Person person4 = new Person("Petya", 23, List.of("One", "Two"));
        System.out.println("toString(): " + person4);
        System.out.println("The fourth object hashcode: " + person4.hashCode());
        System.out.println("The first object equals to the fourth object: " + person.equals(person4));
        System.out.println();
        Person person5 = new Person("Petya", 23, List.of("One", "Three", "Two"));
        System.out.println("toString(): " + person5);
        System.out.println("The fifth object hashcode: " + person5.hashCode());
        System.out.println("The first object equals to the fifth object: " + person.equals(person5));
    }
}
