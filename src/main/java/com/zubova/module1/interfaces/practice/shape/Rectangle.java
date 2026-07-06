package com.zubova.module1.interfaces.practice.shape;

public class Rectangle implements Shape {

    private int height;
    private int width;

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return this.height * this.width;
    }

    @Override
    public double calculatePerimeter() {
        return (this.width + this.height) * 2;
    }

}