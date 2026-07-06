package com.zubova.module1.finalTopic;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Circle {

    private final double radius;

    public final double calculateArea() {
        return Math.PI * radius * radius;
    }

}