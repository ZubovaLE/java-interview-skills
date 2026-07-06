package com.zubova.module1.exception.practice.hard;

import java.util.logging.Logger;

public class ResilienceTaskExecutor {
    private static final Logger LOGGER = Logger.getLogger(ResilienceTaskExecutor.class.getName());
    private static final int MAX_RETRIES = 3;

    public void executeTask(Runnable task) {
        int attempt;
        for (attempt = 1; attempt <= MAX_RETRIES; attempt++) {
            try {
                task.run();
                return;  // Успешное выполнение
            } catch (RuntimeException e) {
                LOGGER.warning("Ошибка выполнения задачи (попытка " + attempt + "): " + e.getMessage());

                if (attempt == MAX_RETRIES) {
                    LOGGER.severe("Критическая ошибка после " + MAX_RETRIES + " попыток");
                    handleFatalError(e);
                    break;
                }

                // Экспоненциальная задержка
                try {
                    Thread.sleep((long) Math.pow(2, attempt) * 1000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }

    private void handleFatalError(Throwable e) {
        // Отправка уведомлений, запись в критический лог
        LOGGER.severe("Фатальная ошибка: " + e.getMessage());
    }
}
