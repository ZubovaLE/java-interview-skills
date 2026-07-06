package com.zubova.module1.exception;

import java.util.Scanner;

class Program {

    public static void main(String[] args) throws Throwable {
        printName(); // здесь возникает исключение, но его никто не обрабатывает
    }

    static void printName() throws Throwable {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name = in.nextLine(); // считываем введенную строку

        // если строка имеет имеет меньше 2-х символов, генерируем исключение
        try {
            if (name.length() < 2) throw new Throwable("Недостаточная длина имени: " + name.length());
        } finally {
            System.out.println("aaa");
        }
        System.out.println("Привет, " + name);
    }
}