package com.zubova.module1.initialization.task.three;

class Parent {
    static void print() {
        System.out.println("Parent");
    }

    public static void main(String[] args) {
        Parent p = new Child();
        p.print(); // Что будет выведено?
    }
}