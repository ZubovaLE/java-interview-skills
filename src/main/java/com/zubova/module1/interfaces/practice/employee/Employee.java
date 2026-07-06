package com.zubova.module1.interfaces.practice.employee;

import lombok.Getter;

public abstract class Employee {

    @Getter
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public abstract double calculateSalary();

}