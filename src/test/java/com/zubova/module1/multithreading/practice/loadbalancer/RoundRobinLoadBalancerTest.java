package com.zubova.module1.multithreading.practice.loadbalancer;


import org.junit.jupiter.api.Test;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.*;

class RoundRobinLoadBalancerTest {

    @Test
    void get_shouldReturnInstancesInRoundRobinOrder() throws TooManyInstancesException {
        LoadBalancer loadBalancer = new RoundRobinLoadBalancer(3);
        URI instance1 = URI.create("http://service-1");
        URI instance2 = URI.create("http://service-2");
        URI instance3 = URI.create("http://service-3");

        loadBalancer.register(instance1);
        loadBalancer.register(instance2);
        loadBalancer.register(instance3);

        assertEquals(instance1, loadBalancer.get());
        assertEquals(instance2, loadBalancer.get());
        assertEquals(instance3, loadBalancer.get());

        assertEquals(instance1, loadBalancer.get());
        assertEquals(instance2, loadBalancer.get());
        assertEquals(instance3, loadBalancer.get());
    }

    @Test
    void register_shouldThrowException_whenCapacityIsExceeded() throws TooManyInstancesException {
        LoadBalancer loadBalancer = new RoundRobinLoadBalancer(1);
        loadBalancer.register(URI.create("http://service-1"));

        assertThrows(TooManyInstancesException.class, () -> loadBalancer.register(URI.create("http://service-2")));
    }

    @Test
    void register_shouldReturnFalse_forDuplicateInstance() throws TooManyInstancesException {
        LoadBalancer loadBalancer = new RoundRobinLoadBalancer(2);
        URI instance1 = URI.create("http://service-1");
        loadBalancer.register(instance1);

        boolean result = loadBalancer.register(instance1);

        assertFalse(result);
    }

    @Test
    void get_shouldReturnNull_whenNoInstancesAreRegistered() {
        LoadBalancer loadBalancer = new RoundRobinLoadBalancer(10);

        assertNull(loadBalancer.get());
    }

    @Test
    void register_shouldNeverExceedCapacity_underConcurrentLoad() throws Exception {
        int capacity = 10;
        LoadBalancer loadBalancer = new RoundRobinLoadBalancer(capacity);
        int attempts = 100;
        try (ExecutorService pool = Executors.newFixedThreadPool(20)) {
            CountDownLatch start = new CountDownLatch(1);

            List<Future<Boolean>> futures = new ArrayList<>();
            for (int i = 0; i < attempts; i++) {
                URI uri = URI.create("http://service-" + i);
                futures.add(pool.submit(() -> {
                    start.await();
                    try {
                        return loadBalancer.register(uri);
                    } catch (TooManyInstancesException e) {
                        return false;
                    }
                }));
            }
            start.countDown();

            long successCount = 0;
            for (Future<Boolean> future : futures) {
                if (future.get()) {
                    successCount++;
                }
            }

            assertEquals(capacity, successCount);
        }
    }

}