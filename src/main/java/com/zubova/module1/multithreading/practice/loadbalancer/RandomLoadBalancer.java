package com.zubova.module1.multithreading.practice.loadbalancer;

import java.net.URI;
import java.util.concurrent.ThreadLocalRandom;

public class RandomLoadBalancer extends AbstractLoadBalancer {

    public RandomLoadBalancer(int maxInstances) {
        super(maxInstances);
    }

    @Override
    public URI get() {
        if (instances.isEmpty()) {
            return null;
        }
        int index = ThreadLocalRandom.current().nextInt();
        return this.instances.get(index);
    }

}
