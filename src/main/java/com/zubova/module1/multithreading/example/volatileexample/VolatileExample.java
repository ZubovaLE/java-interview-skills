package com.zubova.module1.multithreading.example.volatileexample;

class VolatileExample {
    int a = 0;
    volatile boolean flag = false;

    public void writer() {
        a = 42;           // A
        flag = true;      // B (volatile запись)
    }

    public void reader() {
        if (flag) {       // C (volatile чтение)
            System.out.println(a);  // D: всегда печатает 42!
        }
    }
}