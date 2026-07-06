package com.zubova.module1.clone.practice.hard;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
class Person implements Serializable {
    private String name;
    @Getter
    private Address address;
    @Getter
    private List<String> friends; // Изменяемый объект

    @Override
    public String toString() {
        return "Person{name='" + name + "', address=" + address + ", friends=" + friends + "}";
    }
}
