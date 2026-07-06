package com.zubova.module1.serialization.practice.third;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zubova.module1.serialization.practice.first.Student;

import java.util.logging.Logger;

public class JsonSerialization {
    private static final Logger LOGGER = Logger.getLogger(JsonSerialization.class.getName());

    private final ObjectMapper objectMapper = new ObjectMapper();

    public String serializeToJson(Student student) {
        try {
            return objectMapper.writeValueAsString(student);
        } catch (JsonProcessingException e) {
            LOGGER.severe("Failed to serialize object to json{}" + e.getMessage());
            return null;
        }
    }

    public Student deserializeFromJson(String json) {
        try {
            return objectMapper.readValue(json, Student.class);
        } catch (JsonProcessingException e) {
            LOGGER.severe("Failed to deserialize object from json{}" + e.getMessage());
            return null;
        }
    }

}