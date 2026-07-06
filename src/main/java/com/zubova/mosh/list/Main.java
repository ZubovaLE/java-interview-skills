package com.zubova.mosh.list;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        System.out.println(list.getSize());
        list.addLast(10);
        System.out.println(list.getSize());
        list.addLast(20);
        list.addLast(30);
        int[] array = list.toArray();
        System.out.println("Array: " + Arrays.toString(array));
        list.reverse();
        int[] reversedArray = list.toArray();
        System.out.println("Reversed: " + Arrays.toString(reversedArray));
        list.addFirst(40);
        System.out.println(list.getSize());
        list.remove(40);
        list.removeFirst();
        System.out.println(list.getSize());
        System.out.println(list.contains(10));
    }
}
