package com.zubova.module1.inheritance.practice.one;

public class TypeCastingTask {

    public static void main(String[] args) {
        Animal[] animals = {new Dog(), new Cat(), new Cat(), new Dog(), new Cat()};
        int dogCounter = 0;
        int catCounter = 0;
        for (Animal animal : animals) {
            if (animal instanceof Dog) {
                dogCounter++;
                continue;
            }
            if (animal instanceof Cat) {
                catCounter++;
            }
        }
        System.out.println("Dogs amount: " + dogCounter);
        System.out.println("Cats amount: " + catCounter);
    }

}