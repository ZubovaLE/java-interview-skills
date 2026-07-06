package com.zubova.module1.enumT.example.enumSet;

import java.util.EnumSet;
import java.util.Set;

public class EnumSetExample {
    public static void main(String[] args) {
        // Создание набора, содержащего все дни (все Enum константы)
        Set<Day> allDays = EnumSet.allOf(Day.class);
        System.out.println("Все дни: " + allDays);

        // Создание пустого набора для определенного enum
        Set<Day> workday = EnumSet.noneOf(Day.class);
        Day.MONDAY.ordinal();
        workday.add(Day.MONDAY);
        workday.add(Day.TUESDAY);
        workday.add(Day.FRIDAY);
        System.out.println("Рабочие дни: " + workday);

        // Создание набора из диапазона
        Set<Day> weekend = EnumSet.range(Day.SATURDAY, Day.SUNDAY);
        System.out.println("Выходные: " + weekend);
    }
}