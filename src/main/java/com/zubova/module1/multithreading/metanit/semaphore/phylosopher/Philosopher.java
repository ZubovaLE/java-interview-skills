package com.zubova.module1.multithreading.metanit.semaphore.phylosopher;

import java.util.concurrent.Semaphore;

// класс философа
class Philosopher extends Thread {
    Semaphore sem; // семафор. ограничивающий число философов
    int num = 0; // кол-во приемов пищи
    int id; // условный номер философа

    // в качестве параметров конструктора передаем идентификатор философа и семафор
    Philosopher(Semaphore sem, int id) {
        this.sem = sem;
        this.id = id;
    }

    public void run() {
        try {
            while (num < 3)// пока количество приемов пищи не достигнет 3
            {
                //Запрашиваем у семафора разрешение на выполнение
                sem.acquire();
                System.out.println("Философ " + id + " садится за стол");
                sleep(500); // философ ест
                num++;

                System.out.println("Философ " + id + " выходит из-за стола");
                sem.release();
                sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("у философа " + id + " проблемы со здоровьем");
        }
    }
}