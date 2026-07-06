package com.zubova.module1.multithreading.practice.loadbalancer;

import java.net.URI;

public interface LoadBalancer {

    boolean register(URI instance) throws TooManyInstancesException;

    URI get();

}