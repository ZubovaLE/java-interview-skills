package com.zubova.module1.interfaces.practice.vehicle2;

public class Main {

    public static void main(String[] args) {
        ElectricCar tesla = new ElectricCar();
        PetrolCar toyota = new PetrolCar();
        HybridCar prius = new HybridCar();

        // Демонстрация работы электромобиля
        System.out.println("=== Электромобиль ===");
        tesla.start();
        tesla.charge();
        tesla.stop();

        // Демонстрация работы бензинового автомобиля
        System.out.println("\\n=== Бензиновый автомобиль ===");
        toyota.start();
        toyota.refuel();
        toyota.stop();

        // Демонстрация работы гибрида
        System.out.println("\\n=== Гибридный автомобиль ===");
        prius.start();
        prius.charge();
        prius.refuel();
        prius.stop();
    }

}