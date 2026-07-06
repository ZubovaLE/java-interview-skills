package com.zubova.module1.enumT.example.order;

public class Order {
    private OrderState state = OrderState.NEW;

    public void processOrder() {
        try {
           /*
            Проверка возможности перехода заказа из одного состояния в другое
            Проверяет, можно ли перейти из текущего состояния в PROCESSING
            Если переход невозможен, бросает исключение
           */
            state.validateTransition(OrderState.PROCESSING);
           // Если проверка прошла успешно, состояние меняется  
            state = OrderState.PROCESSING;
            // Логика обработки заказа
        } catch (IllegalStateException e) {
            // Обработка ошибки
        }
    }
}