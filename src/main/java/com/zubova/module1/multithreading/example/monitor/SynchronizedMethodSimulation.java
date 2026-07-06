package com.zubova.module1.multithreading.example.monitor;

class SynchronizedBankAccount {
    private double balance;

    SynchronizedBankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Synchronized method to deposit money
    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposited " + amount + ". New balance: " + balance);
        }
    }

    // Synchronized method to withdraw money
    public synchronized void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ". New balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " attempted to withdraw " + amount + " but insufficient funds.");
        }
    }

    // Method to check balance (not necessarily synchronized)
    public double getBalance() {
        return balance;
    }
}

public class SynchronizedMethodSimulation {
    public static void main(String[] args) {
        SynchronizedBankAccount account = new SynchronizedBankAccount(1000);

        // Simulating deposit and withdrawal by threads
        Thread t1 = new Thread(() -> {
            account.deposit(300);
            account.withdraw(50);
        }, "User1");

        Thread t2 = new Thread(() -> {
            account.deposit(200);
            account.withdraw(400);
        }, "User2");

        t1.start();
        t2.start();
    }
}