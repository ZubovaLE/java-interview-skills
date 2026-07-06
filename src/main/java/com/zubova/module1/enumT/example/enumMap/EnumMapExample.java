package com.zubova.module1.enumT.example.enumMap;

import java.util.EnumMap;
import java.util.Map;

public class EnumMapExample {
    public static void main(String[] args) {
        Map<Role, String> rolePermissions = new EnumMap<>(Role.class);

        // Добавление элементов
        rolePermissions.put(Role.ADMIN, "Полный доступ");
        rolePermissions.put(Role.USER, "Чтение и запись");
        rolePermissions.put(Role.GUEST, "Только чтение");

        // Вывод: данные хранятся в порядке объявления в enum, а не добавления
        System.out.println("Права ролей: " + rolePermissions);

        // Получение значения
        System.out.println("Доступ Admin: " + rolePermissions.get(Role.ADMIN));
    }

}