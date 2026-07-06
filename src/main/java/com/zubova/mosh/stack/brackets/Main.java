package com.zubova.mosh.stack.brackets;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String string = "(1+2";
        String string2 = "((1+2)";
        String string3 = ")(";
        BracketExaminer bracketExaminer = new BracketExaminer();
        System.out.println(bracketExaminer.isBalanced(string));
        System.out.println(bracketExaminer.isBalanced(string2));
        System.out.println(bracketExaminer.isBalanced(string3));
    }
}
