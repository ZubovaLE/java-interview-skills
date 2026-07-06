package com.zubova.module1.type;


public class FormatExample {

    public static void main(String[] args) {
        printLaptopInfo("Macbook", 2, 1.68f, true, 0.00000034);
        printLaptopInfo("HP", 8, 1.62f, false, 0.00000054);
    }

    private static void printLaptopInfo(String laptopName, int years, float height, boolean goodWeight, double exp) {
        System.out.printf("My laptop is %s, it's %d years old, it has %.2f height. Does it work? - %b. Example: %e %n",
                laptopName, years, height, goodWeight, exp);
    }

}
