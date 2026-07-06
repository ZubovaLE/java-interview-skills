package com.zubova.module1.multithreading.practice.periodictask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class PeriodicTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(PeriodicTask.class);
    private static final String STOP_COMMAND = "stop";

    public static void main(String[] args) throws InterruptedException {
        DynamicScheduler dynamicScheduler = new DynamicScheduler();
        dynamicScheduler.start(2);

        System.out.println("Enter a number (in seconds) to change the period, or 'stop' to exit.");
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String userCommand = scanner.nextLine();
                if (STOP_COMMAND.equalsIgnoreCase(userCommand)) {
                    break;
                }
                try {
                    long newPeriod = Long.parseLong(userCommand);
                    if (newPeriod > 0) {
                        dynamicScheduler.changePeriod(newPeriod);
                    } else {
                        System.out.println("Period must be a positive number.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number or 'stop'.");
                }
            }
            dynamicScheduler.stop();
        }
    }

}