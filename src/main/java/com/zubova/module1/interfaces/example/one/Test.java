package com.zubova.module1.interfaces.example.one;

public class Test implements MyInterface, MyInterface2 {

    @Override
    public void doSmt() {
        MyInterface.staticCall();
    }

    @Override
    public void print() {
        MyInterface2.super.print();
    }

}
