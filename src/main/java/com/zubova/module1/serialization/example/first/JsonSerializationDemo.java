package com.zubova.module1.serialization.example.first;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class JsonSerializationDemo {
    // Создаем экземпляр ObjectMapper  
    private final ObjectMapper mapper = new ObjectMapper();

    // Метод для сериализации в JSON  
    public String serializeToJson(User user) {
        try {  
            // Настраиваем форматирование JSON для читаемости  
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            
            // Преобразуем объект в JSON строку  
            return mapper.writeValueAsString(user);  
            
        } catch (JsonProcessingException e) {
            System.err.println("Ошибка JSON сериализации: " + e.getMessage());  
            return null;  
        }  
    }  

    // Метод для десериализации из JSON  
    public User deserializeFromJson(String json) {  
        try {  
            // Преобразуем JSON строку обратно в объект  
            return mapper.readValue(json, User.class);  
            
        } catch (JsonProcessingException e) {  
            System.err.println("Ошибка JSON десериализации: " + e.getMessage());  
            return null;  
        }  
    }  

    // Пример использования с файлом  
    public void saveToJsonFile(User user, String filename) {  
        try {  
            // Записываем JSON в файл  
            mapper.writeValue(new File(filename), user);
            
        } catch (IOException e) {
            System.err.println("Ошибка записи JSON в файл: " + e.getMessage());  
        }  
    }  

    // Пример чтения из файла  
    public User readFromJsonFile(String filename) {  
        try {  
            // Читаем JSON из файла  
            return mapper.readValue(new File(filename), User.class);  
            
        } catch (IOException e) {  
            System.err.println("Ошибка чтения JSON из файла: " + e.getMessage());  
            return null;  
        }  
    }  
}
