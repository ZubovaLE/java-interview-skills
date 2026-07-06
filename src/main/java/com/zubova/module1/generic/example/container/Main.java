package com.zubova.module1.generic.example.container;

import java.lang.reflect.Type;

public class Main {

    public static void main(String[] args) {
        Container<String> container = new Container<>();
        Type type;

        try {
            type = container.getClass()
                    .getDeclaredField("value")
                    .getGenericType();
            System.out.println(type);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

    }

}
