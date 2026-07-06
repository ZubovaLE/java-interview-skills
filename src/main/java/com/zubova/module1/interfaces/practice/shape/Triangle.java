package com.zubova.module1.interfaces.practice.shape;

// предположим, что прямоугольный треугольниу
public class Triangle implements Shape {

    private double a; //катет
    private double b; //катет
    private double c; //гипотенуза

    public Triangle(double a, double b) {
        this.a = a;
        this.b = b;
        this.c = Math.sqrt(this.a * this.a + this.b * this.b);
    }

    @Override
    public double calculateArea() {
        return (this.a * this.b) / 2;
    }

    @Override
    public double calculatePerimeter() {
        return this.a + this.b + this.c;
    }
}
