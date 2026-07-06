package com.zubova.module1.record.practice.hard;

public class Main {
    public static void main(String[] args) {
        Transaction deposit = new Transaction(null, 1000.0, Transaction.TransactionType.DEPOSIT);
        System.out.println(deposit.id());
    }
}
