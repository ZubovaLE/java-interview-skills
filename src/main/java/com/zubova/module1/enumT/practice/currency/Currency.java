package com.zubova.module1.enumT.practice.currency;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public enum Currency {
    USD(new BigDecimal("1.0")),
    EUR(new BigDecimal("0.92")),
    GBP(new BigDecimal("0.79")),
    JPY(new BigDecimal("157.50"));

    private static final int DEFAULT_SCALE = 10;
    private static final int FINAL_SCALE = 2;

    private final BigDecimal rateToBaseCurrency;

    Currency(BigDecimal rateToBaseCurrency) {
        this.rateToBaseCurrency = rateToBaseCurrency;
    }

    /**
     * Converts an amount from one currency to another.
     *
     * @param amount       the amount to convert
     * @param fromCurrency the source currency
     * @param toCurrency   the target currency
     * @return the converted amount, rounded to 2 decimal places
     */
    public static BigDecimal convert(BigDecimal amount, Currency fromCurrency, Currency toCurrency) {
        Objects.requireNonNull(amount, "Amount must not be null");
        Objects.requireNonNull(fromCurrency, "Source currency must not be null");
        Objects.requireNonNull(toCurrency, "Target currency must not be null");
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount must not be negative");
        }

        // 1. Convert source amount to base currency (USD)
        BigDecimal amountInBase = amount.divide(fromCurrency.rateToBaseCurrency, DEFAULT_SCALE, RoundingMode.HALF_UP);

        // 2. Convert from base currency to target currency
        BigDecimal convertedAmount = amountInBase.multiply(toCurrency.rateToBaseCurrency);

        return convertedAmount.setScale(FINAL_SCALE, RoundingMode.HALF_UP);
    }
}