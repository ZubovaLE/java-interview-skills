package com.zubova.module1.multithreading.example.deadlock;

public class BankAccount {
    private int id;
    private double balance;

    public void transfer(BankAccount from, BankAccount to, double amount) {
        BankAccount firstLock = from.id < to.id ? from : to;
        BankAccount secondLock = from.id < to.id ? to : from;

        synchronized(firstLock) {
            synchronized(secondLock) {
                from.balance -= amount;
                to.balance += amount;
            }
        }
    }
}