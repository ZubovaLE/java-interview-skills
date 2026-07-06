package com.zubova.module1.multithreading.example.threadpoolexecutor;

import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileCopyManager {
    private final ExecutorService executor;

    public FileCopyManager() {
        this.executor = Executors.newCachedThreadPool();
    }

    public void copyFiles(List<File> sourceFiles, List<File> destFiles) {
        for (int i = 0; i < sourceFiles.size(); i++) {
            FileCopyTask task = new FileCopyTask(sourceFiles.get(i), destFiles.get(i));
            executor.execute(task);
        }
        executor.shutdown();
    }

    private static class FileCopyTask implements Runnable {
        private final File sourceFile;
        private final File destFile;

        public FileCopyTask(File sourceFile, File destFile) {
            this.sourceFile = sourceFile;
            this.destFile = destFile;
        }

        @Override
        public void run() {
            // Копирование файла
            System.out.println("Копирование файла " + sourceFile.getName() + " в " + destFile.getName());
        }
    }
}