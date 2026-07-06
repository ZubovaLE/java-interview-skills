package com.zubova.module1.serialization.example.third;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

// Определяем класс с JAXB аннотациями
@XmlRootElement
public class Person {
    private String name;
    private int age;

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public void setAge(int age) {
        this.age = age;
    }
}