package com.zubova.module1.initialization.practice.one;

public class Solution {

    public static void main(String[] args) {
        ObjectCounter counter1 = new ObjectCounter();
        ObjectCounter counter2 = new ObjectCounter();
        System.out.println(ObjectCounter.getCounter());
    }

}