package com.zubova.module1.serialization.example.first;

public class SerializationExample {
    public static void main(String[] args) {  
        // Создаем объект для сериализации  
        User user = new User("John Doe", 30);
        
        // Создаем демо-класс  
        SerializationDemo demo = new SerializationDemo();
        
        // Сериализуем объект  
        demo.serialize(user, "user.ser");  
        System.out.println("Объект сериализован");  
        
        // Десериализуем объект  
        User deserializedUser = demo.deserialize("user.ser");  
        System.out.println("Объект десериализован");  
        
        // Проверяем результат  
        if (deserializedUser != null) {  
            System.out.println("Имя: " + deserializedUser.getName());  
            System.out.println("Возраст: " + deserializedUser.getAge());  
        }  
        
        // Пример JSON сериализации  
        JsonSerializationDemo jsonDemo = new JsonSerializationDemo();
        String json = jsonDemo.serializeToJson(user);  
        System.out.println("JSON: " + json);  
        
        // Десериализация из JSON  
        User jsonUser = jsonDemo.deserializeFromJson(json);  
        if (jsonUser != null) {  
            System.out.println("JSON десериализация успешна");  
        }  
    }  
}