package com.zubova.module1.enumT.example.order;

public class Main {

    public static void main(String[] args) {
        Order order = new Order();
        try {
            order.processOrder();
        } catch (IllegalStateException e) {
            System.err.println("Ошибка обработки заказа: " + e.getMessage());
        }
        Order invalidOrder = new Order();
        try {
            invalidOrder.processOrder();
            invalidOrder.processOrder();
        } catch (IllegalStateException e) {
            System.err.println("Ожидаемая ошибка: " + e.getMessage());
        }
    }
}