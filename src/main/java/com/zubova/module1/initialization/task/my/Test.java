package com.zubova.module1.initialization.task.my;

public class Test extends ParentClass.ChildClass {

    static {
        System.out.println("Test static is called");
    }

    {
        System.out.println("Test NON-static is called");
    }

    public Test() {
        System.out.println("Test constructor is called");
    }

    @Override
    public void childMethod() {
        super.childMethod();
        System.out.println("test method is called");
    }

    public static void main(String[] args) {
        new Test().childMethod();
    }
}
