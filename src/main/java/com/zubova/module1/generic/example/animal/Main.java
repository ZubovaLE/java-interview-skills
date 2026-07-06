package com.zubova.module1.generic.example.animal;

public class Main {

    public static void main(String[] args) {
        Box<Animal> animalBox = new Box<>(new Animal());
        Box<Cat> catBox = new Box<>(new Cat());
        makeAnimalSound(animalBox);
        makeAnimalSound(catBox);
    }

   private static void makeAnimalSound(Box<? extends Animal> box) {
        box.getValue().makeSound();
    }

}
