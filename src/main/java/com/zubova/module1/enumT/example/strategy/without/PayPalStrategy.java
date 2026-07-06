package com.zubova.module1.enumT.example.strategy.without;

import com.zubova.module1.enumT.example.strategy.PaymentStrategy;

class PayPalStrategy implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Оплата PayPal: " + amount);
    }
}