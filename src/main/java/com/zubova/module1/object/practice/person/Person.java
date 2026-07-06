package com.zubova.module1.object.practice.person;

import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Getter
public class Person {

    private String name;
    private int age;
    private List<String> hobbies;

    public Person(String name, int age, List<String> hobbies) {
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(hobbies, person.hobbies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, hobbies);
    }

    @Override
    public String toString() {
        return String.format("Person{name='%s', age=%d, hobbies=%s}", name, age, hobbies);
    }

}