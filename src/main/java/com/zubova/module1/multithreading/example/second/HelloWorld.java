package com.zubova.module1.multithreading.example.second;

class HelloWorld {
    public static void main(String[] args) {
        MyThread thread = new MyThread();

        System.out.println("Вызываем run() напрямую:");
        thread.run();  // Выполнится в main-потоке

        System.out.println("Вызываем start():");
        thread.start();  // Создаст новый поток
    }
}
