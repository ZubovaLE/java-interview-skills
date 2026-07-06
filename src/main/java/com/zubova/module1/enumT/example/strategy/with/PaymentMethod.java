package com.zubova.module1.enumT.example.strategy.with;

import com.zubova.module1.enumT.example.strategy.PaymentStrategy;

public enum PaymentMethod implements PaymentStrategy {
    CREDIT_CARD {
        @Override
        public void pay(int amount) {
            System.out.println("Оплата картой: " + amount);
        }
    },

    PAYPAL {
        @Override
        public void pay(int amount) {
            System.out.println("Оплата PayPal: " + amount);
        }
    };
}