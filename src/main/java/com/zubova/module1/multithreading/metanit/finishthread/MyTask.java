package com.zubova.module1.multithreading.metanit.finishthread;

class MyTask implements Runnable {

    private boolean isActive;

    void disable() {
        isActive = false;
    }

    MyTask() {
        isActive = true;
    }

    public void run() {
        String taskName = Thread.currentThread().getName();
        System.out.printf("%s started... \n", taskName);

        int counter = 1; // счетчик циклов
        while (isActive) {
            System.out.println("Loop " + counter++);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.out.printf("%s interrupted... \n", taskName);
            }
        }
        System.out.printf("%s finished... \n", taskName);
    }
}