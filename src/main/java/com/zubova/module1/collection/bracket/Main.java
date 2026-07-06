package com.zubova.module1.collection.bracket;

public class Main {

    public static void main(String[] args) {
        System.out.println(BracketBalancer.areBalanced(""));
        System.out.println(BracketBalancer.areBalanced("Some text"));
        System.out.println(BracketBalancer.areBalanced("{{{}}}"));
        System.out.println(BracketBalancer.areBalanced("[({})]"));
        System.out.println(BracketBalancer.areBalanced("[({}]]"));
        System.out.println(BracketBalancer.areBalanced("[({)]]"));
        System.out.println(BracketBalancer.areBalanced("[)"));
        System.out.println(BracketBalancer.areBalanced("{)"));
        System.out.println(BracketBalancer.areBalanced("(]"));
        System.out.println(BracketBalancer.areBalanced("(}"));
    }
}
