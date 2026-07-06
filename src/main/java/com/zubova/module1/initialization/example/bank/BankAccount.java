package com.zubova.module1.initialization.example.bank;

import java.util.HashMap;
import java.util.Map;

public class BankAccount {
    // Статические поля
    private static int totalAccounts = 0;
    private static final double INTEREST_RATE = 0.05;
    private static Map<String, BankAccount> accountsRegistry = new HashMap<>();

    // Нестатические поля  
    private String accountNumber;
    private double balance;

    // Статический блок инициализации  
    static {
        System.out.println("Инициализация банковской системы...");
        // Здесь может быть загрузка конфигурации, подключение к БД и т.д.  
    }

    // так как класс предоставляет фабричный метод createAccount() наш конструктор будет приватным
    private BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        totalAccounts++;
        accountsRegistry.put(accountNumber, this);
    }

    // Статический метод для создания аккаунта (фабричный метод)  
    public static BankAccount createAccount(String accountNumber, double initialBalance) {
        if (accountsRegistry.containsKey(accountNumber)) {
            throw new IllegalArgumentException("Account already exists");
        }
        return new BankAccount(accountNumber, initialBalance);
    }

    // Статический метод для получения аккаунта  
    public static BankAccount getAccount(String accountNumber) {
        return accountsRegistry.get(accountNumber);
    }

    // Статический метод для расчета процентов  
    public static double calculateInterest(double amount) {
        return amount * INTEREST_RATE;
    }

    // Нестатический метод для работы с балансом  
    public void deposit(double amount) {
        this.balance += amount;
    }

    // Статический метод для получения общей статистики  
    public static String getBankStats() {
        return String.format("Total accounts: %d, Total balance: %.2f",
                totalAccounts,
                accountsRegistry.values().stream()
                        .mapToDouble(account -> account.balance)
                        .sum()
        );
    }

    // Геттеры
    public double getBalance() {
        return balance;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    // Пример использования
    public static void main(String[] args) {
        // Создание аккаунтов  
        BankAccount account1 = BankAccount.createAccount("1001", 1000);
        BankAccount account2 = BankAccount.createAccount("1002", 2000);

        // Работа с аккаунтами  
        account1.deposit(500);

        // Получение аккаунта по номеру  
        BankAccount retrievedAccount = BankAccount.getAccount("1001");
        System.out.println("Retrieved account balance: " + retrievedAccount.getBalance());

        // Расчет процентов  
        double interest = BankAccount.calculateInterest(1000);
        System.out.println("Interest for 1000: " + interest);

        // Получение статистики  
        System.out.println(BankAccount.getBankStats());
    }
}  