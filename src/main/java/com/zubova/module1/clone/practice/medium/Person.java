package com.zubova.module1.clone.practice.medium;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Person implements Cloneable {

    private String name;
    private int age;
    private Address address;

    @Override
    protected Person clone() throws CloneNotSupportedException {
        Person clonedPerson = (Person) super.clone();
        clonedPerson.address = address.clone();
        return clonedPerson;
    }

}