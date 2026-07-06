package com.zubova.module1.interfaces.practice.vehicle2;

class ElectricCar implements Vehicle, Electric {
    @Override
    public void start() {
        System.out.println("Электромобиль: Включение электромотора");
    }

    @Override
    public void stop() {
        System.out.println("Электромобиль: Выключение электромотора");
    }

    @Override
    public void charge() {
        System.out.println("Электромобиль: Зарядка аккумулятора");
    }
}
