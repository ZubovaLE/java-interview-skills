package com.zubova.module1.multithreading.practice.workertasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class WorkersTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(WorkersTask.class);

    public static void main(String[] args) throws InterruptedException {
        int threadsCount = 5;
        try (ExecutorService executorService = Executors.newFixedThreadPool(threadsCount)) {
            Random random = new Random();
            List<Future<Integer>> results = new ArrayList<>();

            LOGGER.info("Starting {} workers", threadsCount);
            for (int i = 0; i < threadsCount; i++) {
                Future<Integer> futureResult = executorService.submit(createWorker(random));
                results.add(futureResult);
            }
            LOGGER.info("Main thread is waiting for all workers to complete");

            int successfulTasks = processResults(results);
            LOGGER.info("All works has completed their tasks. Processed results from {} successful tasks.", successfulTasks);
        }
    }

    private static Callable<Integer> createWorker(Random random) {
        return () -> {
            int workTime = random.nextInt(1000, 5001);
            try {
                LOGGER.info("{} started work, will take {} ms", Thread.currentThread().getName(), workTime);
                Thread.sleep(workTime);
                LOGGER.info("{} finished its work", Thread.currentThread().getName());
                return workTime;
            } catch (InterruptedException e) {
                LOGGER.error("Thread {} was interrupted", Thread.currentThread().getName());
                Thread.currentThread().interrupt();
                return -1;
            }
        };
    }

    private static int processResults(List<Future<Integer>> results) throws InterruptedException {
        int successfulTasks = 0;
        for (Future<Integer> result : results) {
            try {
                Integer workTime = result.get();
                if (workTime > 0) {
                    LOGGER.info("Worker result completes in {} ms", workTime);
                    successfulTasks++;
                }
            } catch (ExecutionException e) {
                LOGGER.error("A worker task failed with an exception", e.getCause());
            }
        }
        return successfulTasks;
    }

}
