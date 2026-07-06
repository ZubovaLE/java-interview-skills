package com.zubova.mosh.multithreading.atomic;

public class DownLoadFileTask implements Runnable {

    private final DownloadStatus downloadStatus;

    public DownLoadFileTask(DownloadStatus downloadStatus) {
        this.downloadStatus = downloadStatus;
    }

    @Override
    public void run() {
        System.out.println("Downloading a file...: " + Thread.currentThread().getName());
        for (var i = 0; i < 10_000; i++) {
            downloadStatus.incrementTotalBytes();
        }
        System.out.println("Download complete: " + Thread.currentThread().getName());
    }
}
