package com.zubova.module1.object.practice.clone;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Person implements Cloneable {

    @Setter
    private String name; // Immutable

    private final List<String> hobbies; // Mutable

    public Person(String name, List<String> hobbies) {
        this.name = name;
        this.hobbies = hobbies;
    }
    
    //Альтернативный и предпочтительный подход — использование конструктора копирования:
    public Person(Person other) {
        this.name = other.name;
        this.hobbies = new ArrayList<>(other.hobbies); // Создаем новую копию списка
    }

//    @Override
//    public Person clone() throws CloneNotSupportedException {
//        Person clonedPerson = (Person) super.clone(); // Шаг 1: Поверхностная копия
//        // Шаг 2: Глубоко копируем изменяемые поля
//        clonedPerson.hobbies = new ArrayList<>(this.hobbies);
//        return clonedPerson;
//    }
}