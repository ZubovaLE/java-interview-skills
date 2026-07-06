package com.zubova.module1.serialization.practice.tz;

import lombok.Getter;

import java.io.*;

public class TransientDemo {

    @Getter
    public static class User implements Serializable {

        private static final long serialVersionUID = 1L;
        private String username;
        private transient String password;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }

        @Override
        public String toString() {
            return "User{" +
                   "username='" + username + '\'' +
                   ", password='" + password + '\'' +
                   '}';
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user = new User("JohnDoe", "SuperSecret123");
        System.out.println("Original object: " + user);

        // Сериализация
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOut = new ObjectOutputStream(byteStream);
        objectOut.writeObject(user);
        objectOut.close();

        // Десериализация
        ByteArrayInputStream byteInStream = new ByteArrayInputStream(byteStream.toByteArray());
        ObjectInputStream objectIn = new ObjectInputStream(byteInStream);
        User deserializedUser = (User) objectIn.readObject();
        objectIn.close();

        System.out.println("Deserialized object: " + deserializedUser);
        // Проверяем, что transient поле равно null
        System.out.println("Is password null? " + (deserializedUser.getPassword() == null));
    }
}