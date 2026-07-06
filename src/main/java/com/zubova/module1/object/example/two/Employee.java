package com.zubova.module1.object.example.two;

class Employee extends Person{
    private String company;
 
    Employee(String name, String company) {  
 
        super(name);
        this.company = company; 
    }
 
    @Override
    public boolean equals(Object otherObject){
        System.out.println(otherObject.getClass());
        System.out.println(getClass());
        System.out.println(otherObject instanceof Employee);
        if (!super.equals(otherObject)) return false;
        // super.equals уже проверяет, что this и otherObject представляют один и тот же класс
        Employee empl = (Employee)otherObject;
        // и проверяем равенство их координат
        return this.company.equals(empl.company);
    }
}