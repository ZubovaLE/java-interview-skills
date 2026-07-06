package com.zubova.module1.interfaces.practice.shape;

public class Solution {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle(5.0),
                new Rectangle(4, 6),
                new Triangle(3, 4)
        };

        for (Shape shape : shapes) {
            System.out.printf("Площадь фигуры %s: %.2f%n",
                    shape.getClass().getSimpleName(),
                    shape.calculateArea());
        }
    }
}