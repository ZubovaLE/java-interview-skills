package com.zubova.module1.object.practice.group;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Student {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Student s)) {
            return false;
        }
        return Objects.equals(getName(), s.getName());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}