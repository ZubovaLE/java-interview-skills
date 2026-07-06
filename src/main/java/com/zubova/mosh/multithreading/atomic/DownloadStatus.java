package com.zubova.mosh.multithreading.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class DownloadStatus {
    private AtomicInteger totalBytes =  new AtomicInteger(0);
    private AtomicInteger totalFiles = new AtomicInteger(0);

    public int getTotalBytes() {
        return totalBytes.get();
    }

    public int getTotalFiles() {
        return totalFiles.get();
    }

    public void incrementTotalBytes() {
        totalBytes.incrementAndGet();
    }

    public void incrementTotalFiles() {
        totalFiles.incrementAndGet();
    }

}