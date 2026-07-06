package com.zubova.module1.exception.practice.medium;


// Кастомное исключение для ошибок валидации
// Наследуется от Exception, значит это checked exception
public class ValidationException extends Exception {
    // Конструктор с возможностью передать описание ошибки  
    public ValidationException(String message) {
        // Вызываем конструктор родительского класса с сообщением  
        super(message);
    }
}  