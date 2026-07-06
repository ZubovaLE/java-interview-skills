package com.zubova.module1.clone.practice.medium;

public class Main {

    public static void main(String[] args) {
        Address address = new Address("Aqtobe", "Eset-batyr");
        Person person = new Person("one", 32, address);
        System.out.println("Person name: " + person.getName());
        System.out.println("Person age: " + person.getAge());
        System.out.println("Person address: " + person.getAddress());
        System.out.println("Person address city: " + person.getAddress().getCity());
        System.out.println("Person address street: " + person.getAddress().getStreet());
        try {
            Person clonedPerson = person.clone();
            System.out.println("\nClone before updating: ");
            System.out.println("Clone name: " + clonedPerson.getName());
            System.out.println("Clone age: " + clonedPerson.getAge());
            System.out.println("Clone address: " + clonedPerson.getAddress());
            System.out.println("Clone address city: " + clonedPerson.getAddress().getCity());
            System.out.println("Clone address street: " + clonedPerson.getAddress().getStreet());

            clonedPerson.setName("new");
            clonedPerson.setAge(27);
            clonedPerson.getAddress().setCity("Moscow");
            clonedPerson.getAddress().setStreet("Arbat street");

            System.out.println("\nClone after updating: ");
            System.out.println("Clone name: " + clonedPerson.getName());
            System.out.println("Clone age: " + clonedPerson.getAge());
            System.out.println("Clone address: " + clonedPerson.getAddress());
            System.out.println("Clone address city: " + clonedPerson.getAddress().getCity());
            System.out.println("Clone address street: " + clonedPerson.getAddress().getStreet());

            System.out.println("\nPerson after updating: ");
            System.out.println("Person name: " + person.getName());
            System.out.println("Person age: " + person.getAge());
            System.out.println("Person address: " + person.getAddress());
            System.out.println("Person address city: " + person.getAddress().getCity());
            System.out.println("Person address street: " + person.getAddress().getStreet());
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
