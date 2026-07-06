package com.zubova.module1.multithreading.example.threadpoolexecutor;

import java.io.File;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ImageProcessor {
    private final ThreadPoolExecutor executor;

    public ImageProcessor() {
        // Создаем ThreadPoolExecutor с фиксированным количеством потоков
        this.executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
    }

    public void processImages(List<File> imageFiles) {
        // Добавляем задачи обработки каждого изображения в ThreadPoolExecutor
        for (File imageFile : imageFiles) {
            executor.execute(new ImageTask(imageFile));
        }

        // Останавливаем выполнение задач и закрываем ThreadPoolExecutor
        executor.shutdown();
    }

    private static class ImageTask implements Runnable {
        private final File imageFile;

        public ImageTask(File imageFile) {
            this.imageFile = imageFile;
        }

        @Override
        public void run() {
            // Код для обработки изображения
            System.out.println("Обработка изображения: " + imageFile.getName());
        }
    }
}