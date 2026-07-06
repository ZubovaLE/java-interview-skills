package com.zubova.module1.initialization.practice.one;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

public class ObjectCounter {

    @Getter
    private static AtomicInteger counter;

    public ObjectCounter() {
        counter.incrementAndGet();
    }

}

