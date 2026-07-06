package com.zubova.module1.multithreading.example.threadpoolexecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class BackupService {
    private final ScheduledExecutorService scheduler;

    public BackupService() {
        // Создаем ScheduledThreadPoolExecutor с 1 потоком
        this.scheduler = Executors.newScheduledThreadPool(1);
    }

    public void startBackup(String sourceDir, String destDir, long period, TimeUnit timeUnit) {
        // Создаем новую задачу BackupTask
        BackupTask task = new BackupTask(sourceDir, destDir);

        // Запускаем задачу каждый период времени с использованием ScheduledThreadPoolExecutor
        scheduler.scheduleAtFixedRate(task, 0, period, timeUnit);
    }

    public void stopBackup() {
        // Останавливаем выполнение задач и закрываем пул потоков исполнения
        scheduler.shutdown();
    }

    private static class BackupTask implements Runnable {
        private final String sourceDir;
        private final String destDir;

        public BackupTask(String sourceDir, String destDir) {
            this.sourceDir = sourceDir;
            this.destDir = destDir;
        }

        @Override
        public void run() {
            // Код для резервного копирования файлов
            System.out.println("Резервное копирование файлов...");
        }
    }
}