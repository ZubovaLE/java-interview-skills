package com.zubova.mosh.stack.reverser;

public class ReversingDemo {

    public static void main(String[] args) {
        String string = "abc";
        String emptyString = "";
        StringReverser stringReverser = new StringReverser();
        System.out.println(stringReverser.reverse(string));
        System.out.println(stringReverser.reverse(emptyString));
        System.out.println(stringReverser.reverse(null));
        System.out.println(reverse2(string));
        System.out.println(reverse2(emptyString));
        System.out.println(reverse2(null));
    }

    // почему бы не сделать просто так?
    private static String reverse2(String string) {
        return new StringBuilder(string).reverse().toString();
    }

}
