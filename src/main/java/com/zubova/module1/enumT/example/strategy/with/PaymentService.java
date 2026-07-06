package com.zubova.module1.enumT.example.strategy.with;

import com.zubova.module1.enumT.example.strategy.ShoppingCart;

public class PaymentService {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.setPaymentStrategy(PaymentMethod.CREDIT_CARD);
        cart.checkout(100);
    }
}