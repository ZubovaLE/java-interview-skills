package com.zubova.module1.generic.practice.reflection;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TypeReference<T> {

    Type type;

    public TypeReference() {
        Type superclass = getClass().getGenericSuperclass();
        type = ((ParameterizedType) superclass).getActualTypeArguments()[0];
    }
}