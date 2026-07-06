package com.zubova.module1.serialization.example.first;

import java.io.*;

public class SerializationDemo {
    // Метод для сериализации объекта  
    public void serialize(User user, String filename) {
        // try-with-resources автоматически закроет потоки  
        try (
                // Создаем поток для записи в файл
                FileOutputStream fileOut = new FileOutputStream(filename);

                // Оборачиваем в ObjectOutputStream для сериализации объектов
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)
        ) {
            // Записываем объект в поток  
            // Автоматически сериализует все non-transient поля  
            objectOut.writeObject(user);

        } catch (IOException e) {
            // Обрабатываем возможные ошибки ввода-вывода  
            System.err.println("Ошибка при сериализации: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Метод для десериализации объекта  
    public User deserialize(String filename) {
        try (
                // Создаем поток для чтения из файла
                FileInputStream fileIn = new FileInputStream(filename);

                // Оборачиваем в ObjectInputStream для десериализации объектов
                ObjectInputStream objectIn = new ObjectInputStream(fileIn)
        ) {
            // Читаем объект из потока и приводим к нужному типу  
            // Может выбросить ClassNotFoundException если класс не найден  
            return (User) objectIn.readObject();

        } catch (IOException e) {
            // Обрабатываем ошибки ввода-вывода  
            System.err.println("Ошибка при десериализации: " + e.getMessage());
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            // Обрабатываем ошибку, если класс не найден  
            System.err.println("Класс не найден: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}