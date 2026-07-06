package com.zubova.module1.exception.practice.medium;

// Кастомное исключение для ситуации нехватки средств
// Также является checked exception  
public class InsufficientFundsException extends Exception {
    // Конструктор с возможностью передать описание ошибки  
    public InsufficientFundsException(String message) {  
        // Вызываем конструктор родительского класса с сообщением  
        super(message);  
    }  
}