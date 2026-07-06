package com.zubova.module1.interfaces.practice.vehicle2;

// Бензиновый автомобиль
class PetrolCar implements Vehicle, Fuel {
    @Override
    public void start() {
        System.out.println("Бензиновый автомобиль: Запуск двигателя");
    }

    @Override
    public void stop() {
        System.out.println("Бензиновый автомобиль: Остановка двигателя");
    }

    @Override
    public void refuel() {
        System.out.println("Бензиновый автомобиль: Заправка топливом");
    }
}
