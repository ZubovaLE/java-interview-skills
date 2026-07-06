package com.zubova.module1.type;

class Program {
    public static void main(String[] args) {

        int x = 5;
        System.out.println("x: " + x);

        {
            int y = 10;
            System.out.println("y: " + y);
            System.out.println("x: " + x);
        }  // здесь область действия переменной y завершается

        // System.out.println("y: " + y);  // здесь использовать переменную y нельзя

    }   // здесь область действия переменной x завершается

    // метод test образует новую локальную область видимости
    public static void test() {
        // System.out.println("x: " + x); // здесь использовать переменную x нельзя
    }
}