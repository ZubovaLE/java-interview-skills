package com.zubova.module1.interfaces.example.one;

public interface MyInterface {

    int CONST_ONE = 1;

    void doSmt();

    default void print() {
        System.out.println("MyInterface");
    }

    static void staticCall(){
        System.out.println("static call");
    }
    class MyClass {
        //...
    }

    interface MyOtherInterface {
        void doSmt2();

        default void print2(){
            System.out.println(CONST_ONE);
        }
    }

}