package com.zubova.module1.serialization.example.first;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

// Объявляем класс, который будет сериализуемым
public class User implements Serializable {
    // Уникальный идентификатор версии класса  
    // Используется для проверки совместимости при десериализации  
    private static final long serialVersionUID = 1L;

    // Обычное поле - будет сериализовано  
    @Getter
    @Setter
    private String name;

    // Обычное поле - будет сериализовано  
    @Getter
    @Setter
    private int age;

    // transient поле - будет исключено из сериализации  
    // Полезно для паролей, временных данных, кэшей  
    private transient String tempData;

    // Статическое поле - не будет сериализовано  
    // Принадлежит классу, а не объекту  
    private static String staticField;

    public User() {
    }

    // Конструктор
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

}