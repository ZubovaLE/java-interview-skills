package com.zubova.module1.multithreading.metanit.sync.block;

class CountThread implements Runnable {

    CommonResource res;

    CountThread(CommonResource res) {
        this.res = res;
    }

    public void run() {
        synchronized (res) {  // определяем синхронизированный блок
            // до конца блок идет критическая секция
            res.x = 1;
            for (int i = 1; i < 5; i++) {
                System.out.printf("%s %d \n", Thread.currentThread().getName(), res.x);

                res.x++;

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}