package com.zubova.module1.string.example;

import java.util.HashSet;
import java.util.Set;

public class StringHelper {
    public static Set<String> permutationFinder(String str) {
        Set<String> perm = new HashSet<String>();

        // Базовые случаи
        if (str == null) return null;
        if (str.length() == 0) {
            perm.add("");
            return perm;
        }

        // Получаем первый символ и остаток строки
        char initial = str.charAt(0);
        String remainder = str.substring(1);

        // Рекурсивно находим перестановки для остатка
        Set<String> words = permutationFinder(remainder);

        // Вставляем первый символ во все возможные позиции
        for (String newStr : words) {
            for (int i = 0; i <= newStr.length(); i++) {
                perm.add(charInsert(newStr, initial, i));
            }
        }
        return perm;
    }

    // Вспомогательный метод для вставки символа в строку
    public static String charInsert(String str, char c, int position) {
        String begin = str.substring(0, position);
        String end = str.substring(position);
        return begin + c + end;
    }
}
