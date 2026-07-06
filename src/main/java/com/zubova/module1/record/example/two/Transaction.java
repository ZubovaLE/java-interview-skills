package com.zubova.module1.record.example.two;

import java.time.LocalDate;

// Record для представления финансовой транзакции
record Transaction(
        String description,   // описание транзакции
        double amount,        // сумма
        LocalDate date,       // дата транзакции
        TransactionType type  // тип транзакции
) {
    // Дополнительная валидация в компактном конструкторе  
    public Transaction {
        if (amount < 0) {
            throw new IllegalArgumentException("Сумма транзакции не может быть отрицательной");
        }
    }

    // Статический метод для создания транзакции  
    public static Transaction createDefault() {
        return new Transaction(
                "Без описания",
                0.0,
                LocalDate.now(),
                TransactionType.OTHER
        );
    }
}  