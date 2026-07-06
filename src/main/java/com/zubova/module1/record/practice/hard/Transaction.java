package com.zubova.module1.record.practice.hard;

record Transaction(
    String id,
    double amount,
    TransactionType type
) {
    // Компактный конструктор с расширенной валидацией
    Transaction {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма транзакции должна быть положительной");
        }

        // Генерация уникального ID, если не передан
        if (id == null || id.isEmpty()) {
            id = generateUniqueId();
        }
    }

    // Статический метод генерации ID
    private static String generateUniqueId() {
        return "TX-" + System.currentTimeMillis();
    }

    // Перечисление типов транзакций
    enum TransactionType {
        DEPOSIT, WITHDRAWAL, TRANSFER
    }
}