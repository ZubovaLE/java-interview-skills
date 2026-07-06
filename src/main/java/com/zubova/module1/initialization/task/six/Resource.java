package com.zubova.module1.initialization.task.six;

class Resource {
    static Resource instance = new Resource();
    static int x = 10;

    Resource() {
        x++;
    }

    public static void main(String[] args) {
        new Resource();
        System.out.println(Resource.instance.x);
        System.out.println(Resource.x);
    }

}