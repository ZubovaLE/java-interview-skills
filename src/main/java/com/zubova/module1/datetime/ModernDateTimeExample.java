package com.zubova.module1.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class ModernDateTimeExample {
    public static void main(String[] args) {
        // Текущая дата и время
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Работа с временными зонами
        ZonedDateTime moscowTime = ZonedDateTime.now(ZoneId.of("Europe/Moscow"));
        ZonedDateTime nyTime = moscowTime.withZoneSameInstant(ZoneId.of("America/New_York"));

        // Форматирование и парсинг
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        String formattedDateTime = currentDateTime.format(formatter);
        LocalDateTime parsedDateTime = LocalDateTime.parse("03.09.2024 15:30", formatter);

        // Вывод
        System.out.println("Сегодня: " + today);
        System.out.println("Текущее время: " + now);
        System.out.println("Текущие дата и время: " + currentDateTime);
        System.out.println("Время в Москве: " + moscowTime);
        System.out.println("Время в Нью-Йорке: " + nyTime);
        System.out.println("Форматированная дата: " + formattedDateTime);
        System.out.println("Распарсенная дата: " + parsedDateTime);
    }
}