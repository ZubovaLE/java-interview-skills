package com.zubova.mosh.array;

public class Main {
    public static void main(String[] args) {
        DynamicArray numbers = new DynamicArray(3);
        numbers.insert(10);
        numbers.insert(20);
        numbers.insert(30);
        numbers.insert(40);
        numbers.insertAt(2, 80);
//        numbers.removeAt(0);
        System.out.println("index of 20: " + numbers.indexOf(20));
        System.out.println("max: " + numbers.max());
        System.out.println("\nAll items: ");
        numbers.print();
        numbers.reverse();
        System.out.println("\nReversed items: ");
        numbers.print();


        System.out.println("\nTest 2");
        DynamicArray numbers1 = new DynamicArray(4);
        numbers1.insert(10);
        numbers1.insert(20);
        numbers1.insert(10);
        numbers1.insert(30);
        numbers1.insert(50);

        DynamicArray numbers2 = new DynamicArray(2);
        numbers2.insert(11);
        numbers2.insert(10);
        numbers2.insert(10);

        DynamicArray intersect = numbers1.intersect(numbers2);
        System.out.println("Intersect result");
        intersect.print();
    }
}
