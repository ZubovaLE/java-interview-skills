package com.zubova.module1.multithreading.practice.periodictask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class DynamicScheduler {

    private static final Logger LOGGER = LoggerFactory.getLogger(DynamicScheduler.class);
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    private final Runnable task = () -> LOGGER.info("Current date and time: {}", LocalDateTime.now());
    private ScheduledFuture<?> currentTaskFuture;

    public void start(long initialPeriodSeconds) {
        LOGGER.info("Start executing the task with period: {} seconds", initialPeriodSeconds);
        currentTaskFuture = executorService.scheduleAtFixedRate(task, 0, initialPeriodSeconds, TimeUnit.SECONDS);
    }

    public void changePeriod(long newPeriodSeconds) {
        if (currentTaskFuture != null) {
            currentTaskFuture.cancel(false);
        }
        LOGGER.info("Changing period to: {} seconds", newPeriodSeconds);
        currentTaskFuture = executorService.scheduleAtFixedRate(task, 0, newPeriodSeconds, TimeUnit.SECONDS);
    }

    public void stop() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
        LOGGER.info("Scheduler has been stopped.");
    }

}
