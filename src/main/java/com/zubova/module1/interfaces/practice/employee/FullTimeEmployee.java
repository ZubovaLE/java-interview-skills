package com.zubova.module1.interfaces.practice.employee;

public class FullTimeEmployee extends Employee {

    private double fixedSalary;

    public FullTimeEmployee(String name, int id, double fixedSalary) {
        super(name, id);
        this.fixedSalary = fixedSalary;
    }

    @Override
    public double calculateSalary() {
        return fixedSalary;
    }

}