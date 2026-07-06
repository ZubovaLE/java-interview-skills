package com.zubova.module1.initialization.task.four;

class Counter {
    static int count;
    int instanceCount;

    Counter() {
        count++;
        instanceCount++;
    }

    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        System.out.println(c1.count + " " + c1.instanceCount);
        System.out.println(c2.count + " " + c2.instanceCount);
    }
}