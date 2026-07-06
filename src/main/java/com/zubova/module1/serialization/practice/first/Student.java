package com.zubova.module1.serialization.practice.first;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final int EDUCATION_DURATION_YEARS = 4;

    @Setter
    private String lastname;
    @Setter
    private String name;
    @Setter
     private transient String surname;
    @Setter
    private Specialty specialty;

    public enum Specialty implements Serializable {
        IT, FINANCE, NUCLEAR_PHYSICS
    }

}
