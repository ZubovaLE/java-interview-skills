package com.zubova.module1.lambda.practice.first;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
class Transaction {
    private String type;
    private double amount;
    private String currency;
}