package com.zubova.module1.record.practice.medium;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Transaction(BigDecimal amount, TransactionType type, LocalDateTime data) {

    public Transaction {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }
        if (type == null) {
            throw new IllegalArgumentException("You should input the type!");
        }
    }

    public enum TransactionType {
        WITHDRAWAL, RECEIVE
    }
}
