package com.zubova.module1.object.example.two;

class Person{
    private String name;
 
    Person(String name) {  this.name = name; }
 
    @Override
    public boolean equals(Object otherObject){
          
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
  
        Person p = (Person)otherObject;
        return this.name == p.name;
    }
}