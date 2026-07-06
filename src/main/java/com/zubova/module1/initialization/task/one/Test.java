package com.zubova.module1.initialization.task.one;

class Test {
    static int counter = 0;
    Test() {
        counter++;
    }

    public static void main(String[] args) {
        Test t1 = new Test();
        Test t2 = new Test();
        System.out.println(Test.counter);
    }
}