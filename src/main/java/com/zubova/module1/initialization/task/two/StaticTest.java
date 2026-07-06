package com.zubova.module1.initialization.task.two;

class StaticTest {
    static int x = 1;
    static {
        x = 2;
    }
    static {
        x = 3;
    }

    public static void main(String[] args) {
        new StaticTest();
        System.out.println(StaticTest.x);
    }
}
