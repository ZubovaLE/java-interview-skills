package com.zubova.module1;

public class StaticInitPuzzle {
    static {
        // Static block 1
        x = getValue() - 1;
    }

    static int x = 5;

    private static int getValue() {
        return x + 2;
    }

    static {
        // Static block 2
        y = x + 1;
    }

    static int y;

    public static void main(String[] args) {
        System.out.println(StaticInitPuzzle.x);
        System.out.println(StaticInitPuzzle.y);
    }
}