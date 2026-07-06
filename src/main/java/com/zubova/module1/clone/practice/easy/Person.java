package com.zubova.module1.clone.practice.easy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Person implements Cloneable {

    private String name;
    private int age;

    @Override
    protected Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }

}