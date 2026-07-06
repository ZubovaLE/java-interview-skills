package com.zubova.module1.collection.bracket;

import java.util.Map;
import java.util.Stack;

public class BracketBalancer {
    private static final Map<Character, Character> BRACKETS_MAP = Map.of(
            '}', '{',
            ')', '(',
            ']', '['
    );

    public static boolean areBalanced(String string) {
        Stack<Character> leftBrackets = new Stack<>();
        char c;
        for (int i = 0; i < string.length(); i++) {
            c = string.charAt(i);
            if (BRACKETS_MAP.containsValue(c)) {
                leftBrackets.push(c);
                continue;
            }
            if (BRACKETS_MAP.containsKey(c)) {
                if (leftBrackets.isEmpty()) {
                    return false;
                }
                if (leftBrackets.pop() != BRACKETS_MAP.get(c)) {
                    return false;
                }
            }
        }
        return leftBrackets.empty();
    }

}
