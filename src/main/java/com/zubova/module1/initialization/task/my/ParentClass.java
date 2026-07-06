package com.zubova.module1.initialization.task.my;

class ParentClass {

//    private static final int COUNTER = 0;

    static {
        System.out.println("Parent static is called");
    }

    {
        System.out.println("Parent NON-static is called");
    }

    public ParentClass() {
        System.out.println("Parent constructor is called");
    }

    public static class ChildClass {
        static {
            System.out.println("Child static is called");
        }

        {
            System.out.println("Child NON-static is called");
        }

        public ChildClass() {
            System.out.println("Child constructor is called");
        }

        public void childMethod() {
            System.out.println("child method is called");
        }
    }

}
