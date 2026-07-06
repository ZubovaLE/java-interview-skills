package com.zubova.module1.exception.practice.medium;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Transaction {
    private double amount;
    private String accountId;
}