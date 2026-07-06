package com.zubova.module1.serialization.example.second;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CustomUser implements Serializable {
    private static final long serialVersionUID = 1L;  
    private String username;  
    private String password;
    private transient String decryptedPassword;

    // Кастомный метод записи объекта  
    private void writeObject(ObjectOutputStream out) throws IOException {
        // Вызываем стандартную сериализацию  
        out.defaultWriteObject();  
        
        // Добавляем кастомную логику  
        // Например, шифруем пароль перед сериализацией  
        String encryptedPassword = encrypt(password);  
        out.writeObject(encryptedPassword);  
    }  

    // Кастомный метод чтения объекта  
    private void readObject(ObjectInputStream in)
            throws IOException, ClassNotFoundException {  
        // Вызываем стандартную десериализацию  
        in.defaultReadObject();  
        
        // Добавляем кастомную логику  
        // Например, дешифруем пароль после десериализации  
        String encryptedPassword = (String) in.readObject();  
        this.decryptedPassword = decrypt(encryptedPassword);  
    }  

    // Вспомогательные методы шифрования/дешифрования  
    private String encrypt(String data) {  
        // Реализация шифрования  
        return data + "encrypted";  
    }  

    private String decrypt(String data) {  
        // Реализация дешифрования  
        return data.replace("encrypted", "");  
    }  
}