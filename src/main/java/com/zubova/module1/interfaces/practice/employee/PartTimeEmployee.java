package com.zubova.module1.interfaces.practice.employee;

public class PartTimeEmployee extends Employee {

    private double fixedSalary;

    public PartTimeEmployee(String name, int id, double fixedSalary) {
        super(name, id);
        this.fixedSalary = fixedSalary;
    }

    @Override
    public double calculateSalary() {
        return fixedSalary/2;
    }

}
