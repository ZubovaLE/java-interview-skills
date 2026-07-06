package com.zubova.module1.clone.practice.hard;

import lombok.AllArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
class Address implements Serializable {
    @Setter
    private String city;
    private String street;

    @Override
    public String toString() {
        return "Address{city='" + city + "', street='" + street + "'}";
    }
}
