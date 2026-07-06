package com.zubova.module1.clone.practice.medium;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Address implements Cloneable {

    private String city;
    private String street;

    @Override
    protected Address clone() throws CloneNotSupportedException {
        return new Address(this.city, this.street);
    }

}