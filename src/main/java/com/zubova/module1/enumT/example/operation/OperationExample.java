package com.zubova.module1.enumT.example.operation;

public class OperationExample {

    public static void main(String[] args) {
        double result1 = Operation.PLUS.apply(5, 3);    // 8.0
        double result2 = Operation.MINUS.apply(5, 3);   // 2.0
        double result3 = Operation.TIMES.apply(5, 3);   // 15.0
        double result4 = Operation.DIVIDE.apply(6, 2);  // 3.0
    }
}