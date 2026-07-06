package com.zubova.module1.multithreading.practice.loadbalancer;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class AbstractLoadBalancer implements LoadBalancer {

    protected final int maxInstances;
    protected final List<URI> instances = new CopyOnWriteArrayList<>();
    private final Lock registerLock = new ReentrantLock();

    public AbstractLoadBalancer(int maxInstances) {
        if (maxInstances <= 0) {
            throw new IllegalArgumentException("Maximum number of instances must be positive.");
        }
        this.maxInstances = maxInstances;
    }

    @Override
    public final boolean register(URI instance) throws TooManyInstancesException {
        Objects.requireNonNull(instance, "instance must not be null");
        registerLock.lock();
        try {
            if (instances.size() >= maxInstances) {
                throw new TooManyInstancesException("Cannot register instance. Load balancer is full.");
            }
            if (instances.contains(instance)) {
                return false;
            }
            instances.add(instance);
            return true;
        } finally {
            registerLock.unlock();
        }
    }

}
