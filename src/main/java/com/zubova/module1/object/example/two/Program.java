package com.zubova.module1.object.example.two;

public class Program{
       
    public static void main(String[] args) {
        Employee empl1 = new Employee("Tom", "Yandex");
        Employee empl2 = empl1;

        boolean result = empl1.equals(empl2);
        System.out.println(result);    // true

        Person tom = new Employee("Tom", "Yandex");
        result = empl1 .equals(tom);
        System.out.println(result);    // true
 
        result = empl1 .equals(new Employee("Bob", "Google"));
        System.out.println(result);    // false
 
        result = empl1.equals(new Person("Tom"));
        System.out.println(result);    // false
 
        result = empl1 .equals(null);
        System.out.println(result);    // false
    }
}