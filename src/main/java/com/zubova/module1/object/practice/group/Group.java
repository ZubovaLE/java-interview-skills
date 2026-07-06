package com.zubova.module1.object.practice.group;

import lombok.Getter;

import java.util.Objects;
import java.util.Set;

@Getter
class Group {

    private Set<Student> students;

    public Group(Set<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Group group = (Group) o;
        return Objects.equals(students, group.students);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(students);
    }

    @Override
    public String toString() {
        return "Group{students=" + students + '}';
    }

}
