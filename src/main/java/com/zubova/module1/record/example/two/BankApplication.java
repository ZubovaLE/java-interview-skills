package com.zubova.module1.record.example.two;

import java.time.LocalDate;

public class BankApplication {
    public static void main(String[] args) {
        // Создание Record для транзакции  
        Transaction salary = new Transaction(
                "SALARY_DEPOSIT",
                50000.0,
                LocalDate.now(),
                TransactionType.INCOME
        );

        // Использование методов Record  
        System.out.println("Транзакция: " + salary.description());
        System.out.println("Сумма: " + salary.amount());
        System.out.println("Дата: " + salary.date());
        System.out.println("Тип: " + salary.type());
    }
}