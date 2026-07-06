package com.zubova.module1.generic.example.food;

public class Main {

    public static void main(String[] args) {
        Box<Food> foodBox = new Box<>();
        Box<FruitFood> fruitBox = new Box<>();

        Feeder<Food> feeder = new Feeder<>();

        feeder.putFood(foodBox);     // ОК - можно класть в коробку с едой
        feeder.putFood(fruitBox);    // ОК - можно класть в коробку с фруктами

        feeder.takeFood(foodBox);    // ОК
        feeder.takeFood(fruitBox);   // ОК - можно брать из коробки с фруктами
    }
}
