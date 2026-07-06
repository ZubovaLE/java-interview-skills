package com.zubova.module1.enumT.practice.currency;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        try {
            // Конвертация 100 USD в EUR
            BigDecimal usdToEur = Currency.convert(
                    BigDecimal.valueOf(100),
                    Currency.USD,
                    Currency.EUR
            );
            System.out.println("100 USD to EUR: " + usdToEur);

            // Конвертация 500 EUR в GBP
            BigDecimal eurToGbp = Currency.convert(
                    BigDecimal.valueOf(500),
                    Currency.EUR,
                    Currency.GBP
            );
            System.out.println("500 EUR to GBP: " + eurToGbp);
        } catch (Exception e) {
            System.err.println("Ошибка при конвертации: " + e.getMessage());
        }
    }

}
