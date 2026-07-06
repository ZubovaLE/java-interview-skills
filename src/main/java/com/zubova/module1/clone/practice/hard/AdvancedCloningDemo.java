package com.zubova.module1.clone.practice.hard;

import org.apache.commons.lang3.SerializationUtils;

import java.util.ArrayList;
import java.util.List;

public class AdvancedCloningDemo {

    public static void main(String[] args) {
        // 1. Создаем оригинальный объект со сложной структурой
        List<String> originalFriends = new ArrayList<>();
        originalFriends.add("Bob");

        Person originalPerson = new Person("John", new Address("New-York", "5th Avenue"), originalFriends);
        System.out.println("Original: " + originalPerson);

        // 2. Выполняем глубокое клонирование через сериализацию
        // Для этого нужна зависимость org.apache.commons:commons-lang3
        Person clonedPerson = SerializationUtils.clone(originalPerson);
        System.out.println("Cloned:   " + clonedPerson);
        System.out.println("---");

        // 3. Изменяем вложенные объекты в клоне
        System.out.println("Modifying cloned object...");
        clonedPerson.getAddress().setCity("Boston");
        clonedPerson.getFriends().add("Alice");

        // 4. Проверяем, что оригинал не изменился
        System.out.println("After modification:");
        System.out.println("Original: " + originalPerson);
        System.out.println("Cloned:   " + clonedPerson);

        // 5. Проверяем, что ссылки на вложенные объекты разные
        boolean isAddressShared = originalPerson.getAddress() == clonedPerson.getAddress();
        boolean areFriendsShared = originalPerson.getFriends() == clonedPerson.getFriends();
        System.out.println("\nIs address object shared? " + isAddressShared); // false
        System.out.println("Are friends list object shared? " + areFriendsShared); // false
    }
}