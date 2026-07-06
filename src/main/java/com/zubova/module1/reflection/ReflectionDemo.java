package com.zubova.module1.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionDemo {
    private static class SecretClass {
        // Приватное статическое поле
        private static int secretCounter = 42;

        // Приватный метод
        private String secretMethod() {
            return "Секретное сообщение";
        }
    }

    public static void main(String[] args) throws Exception {
        SecretClass instance = new SecretClass();

        // Работа с приватным статическим полем
        Field counterField = SecretClass.class.getDeclaredField("secretCounter");
        counterField.setAccessible(true);

        // Чтение значения
        int currentValue = (int) counterField.get(null);  // null для статических полей
        System.out.println("Текущее значение: " + currentValue);

        // Изменение приватного поля
        counterField.set(null, 100);

        // Работа с приватным методом
        Method secretMethod = SecretClass.class.getDeclaredMethod("secretMethod");
        secretMethod.setAccessible(true);

        String result = (String) secretMethod.invoke(instance);
        System.out.println("Результат секретного метода: " + result);
    }
}
