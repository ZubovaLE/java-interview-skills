package com.zubova.module1.multithreading.example.monitor;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Синхронизированный метод снятия средств
    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " снимает " + amount);
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " завершил транзакцию. Новый баланс: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " недостаточно средств. Текущий баланс: " + balance);
        }
    }

    // Геттер для баланса
    public synchronized double getBalance() {
        return balance;
    }
}