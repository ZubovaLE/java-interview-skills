package com.zubova.module1.generic.practice.builder;

public abstract class Builder<T extends Builder<T>> {
    @SuppressWarnings("unchecked")
    protected T self() {
        return (T) this;
    }
}
