package com.zubova.module1.serialization.practice.second;

import java.io.*;
import java.util.logging.Logger;

public class CustomStudentSerialization {

    private static final Logger LOGGER = Logger.getLogger(CustomStudentSerialization.class.getName());

    public void serialize(CustomStudent student, String fileName) {
        try (ObjectOutputStream objectOutputStream =
                     new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(student);
        } catch (IOException e) {
            LOGGER.severe("Failed to serialize object {}" + e.getMessage());
        }
    }

    public CustomStudent deserialize(String fileName) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return (CustomStudent) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            LOGGER.severe("Failed to deserialize object {}" + e.getMessage());
            return null;
        }
    }

}
