package com.zubova.module1.initialization.task.five;

class StaticInit {
    static int x = getValue();
    static int y = 2;

    static {
        y = x + 2;
    }

    static int getValue() {
        return y + 1;
    }

    public static void main(String[] args) {
        System.out.println(StaticInit.x);
        System.out.println(StaticInit.y);
    }
}