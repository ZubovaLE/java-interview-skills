package com.zubova.module1.method.example.generic;

import java.util.List;

public class GenericExample {
    // Первый метод принимает список строк
    public void process(List<String> items) {
        for (String item : items) {
            System.out.println(item.toUpperCase());
        }
    }

    // Второй метод принимает список чисел – это вызовет ошибку компиляции!
//    public void process(List<Integer> numbers) {
//        int sum = 0;
//        for (Integer num : numbers) {
//            sum += num;
//        }
//        System.out.println("Sum: " + sum);
//    }
}

