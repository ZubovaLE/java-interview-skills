package com.zubova.module1.multithreading.practice.loadbalancer;

import java.net.URI;
import java.util.concurrent.atomic.AtomicInteger;

public class RoundRobinLoadBalancer extends AbstractLoadBalancer {

    private final AtomicInteger counter = new AtomicInteger(0);

    public RoundRobinLoadBalancer(int maxInstances) {
        super(maxInstances);
    }

    @Override
    public URI get() {
        if (instances.isEmpty()) {
            return null;
        }
        int index = (counter.getAndIncrement() & Integer.MAX_VALUE) % instances.size();
        return instances.get(index);
    }

}
