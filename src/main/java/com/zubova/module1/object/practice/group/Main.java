package com.zubova.module1.object.practice.group;

import java.util.Collections;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Group group1 = new Group(Set.of(new Student("One"), new Student("Two"), new Student("Three")));
        System.out.println("toString(): " + group1);
        System.out.println("The first object hashcode: " + group1.hashCode());
        System.out.println("The first object equals to itself: " + group1.equals(group1));
        System.out.println("The first object equals to itself (the second call): " + group1.equals(group1));
        System.out.println();
        Group group2 = new Group(Set.of(new Student("Two"), new Student("One"), new Student("Three")));
        System.out.println("toString(): " + group2);
        System.out.println("The second object hashcode: " + group2.hashCode());
        System.out.println("The first object equals to the second object: " + group1.equals(group2));
        System.out.println("The second object equals to the first object (symmetrical): " + group2.equals(group1));
        System.out.println();
        Group group3 = new Group(Set.of(new Student("Three"), new Student("Two"), new Student("One")));
        System.out.println("toString(): " + group3);
        System.out.println("The third object hashcode: " + group3.hashCode());
        System.out.println("The second object equals to the third object: " + group2.equals(group3));
        System.out.println("The first object equals to the third object: " + group1.equals(group3));
        System.out.println();
        System.out.println("The first object equals to null: " + group1.equals(null));
        System.out.println();
        Group group4 = new Group(Collections.emptySet());
        System.out.println("toString(): " + group4);
        System.out.println("The fourth object hashcode: " + group4.hashCode());
        System.out.println("The first object equals to the fourth object: " + group1.equals(group4));
        System.out.println();
        Group group5 = new Group(Set.of(new Student("five")));
        System.out.println("toString(): " + group5);
        System.out.println("The fifth object hashcode: " + group5.hashCode());
        System.out.println("The first object equals to the fifth object: " + group1.equals(group5));
    }

}
