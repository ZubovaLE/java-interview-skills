package com.zubova.module1.interfaces.practice.vehicle2;

// Гибридный автомобиль
class HybridCar implements Vehicle, Electric, Fuel {
    @Override
    public void start() {
        System.out.println("Гибрид: Запуск гибридной системы");
    }

    @Override
    public void stop() {
        System.out.println("Гибрид: Остановка гибридной системы");
    }

    @Override
    public void charge() {
        System.out.println("Гибрид: Зарядка электрической системы");
    }

    @Override
    public void refuel() {
        System.out.println("Гибрид: Заправка топливного бака");
    }
}