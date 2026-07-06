package com.zubova.module1.generic.example.food;

class Feeder<T> {
    private Box<T> foodBox;

    // Producer - коробка ОТДАЕТ еду
    public void takeFood(Box<? extends Food> source) {
        Food food = source.getItem();  // Можно взять еду
        System.out.println("Взяли " + food.name);
    }

    // Consumer - коробка ПРИНИМАЕТ еду
    public void putFood(Box<? super FruitFood> target) {
        target.setItem(new FruitFood()); // Можно положить фрукт
    }
}