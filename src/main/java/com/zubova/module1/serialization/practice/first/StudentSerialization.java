package com.zubova.module1.serialization.practice.first;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentSerialization {

    private static final Logger LOGGER = Logger.getLogger(StudentSerialization.class.getName());

    public void serialize(Student student, String fileName) {
        try (ObjectOutputStream objectOutputStream =
                     new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(student);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to serialize object: " + e.getMessage(), e);
        }
    }

    public Student deserialize(String fileName) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Student) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Failed to deserialize object: " + e.getMessage(), e);
            return null;
        }
    }

}
