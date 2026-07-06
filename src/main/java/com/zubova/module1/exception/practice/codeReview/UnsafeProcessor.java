package com.zubova.module1.exception.practice.codeReview;

import java.util.List;
import java.util.logging.Logger;

public class UnsafeProcessor {
    private static final int MAX_RETRIES = 3;
    private static final Logger LOGGER = Logger.getLogger(UserValidator.class.getName());

    public void processData(List<String> data) {
        for (String item : data) {
            for (int attempts = 1; attempts <= MAX_RETRIES; attempts++) {
                try {
                    processItem(item);
                    break;
                } catch (Exception e) {
                    LOGGER.warning(String.format("Attempt %s was failed", attempts));
                    if (attempts == MAX_RETRIES) {
                        LOGGER.severe("All attempts was failed");
                        return;
                    }
                    attempts++;
                }
            }
        }
    }

    private void processItem(String item) throws Exception {
        // Имитация сложной операции
        if (Math.random() < 0.5) {
            throw new Exception("Случайная ошибка");
        }
    }
}