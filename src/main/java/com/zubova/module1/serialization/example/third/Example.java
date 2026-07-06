package com.zubova.module1.serialization.example.third;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.yaml.snakeyaml.Yaml;

import java.io.File;

public class Example {

    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(12);
        person.setName("Mike");
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(Person.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(person, new File("person.xml"));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

        // Создаем YAML парсер
        Yaml yaml = new Yaml();
        // Сериализация
        String yamlString = yaml.dump(person);
        // Десериализация
        Person person2 = yaml.loadAs(yamlString, Person.class);
        System.out.println(person2);
    }
}
