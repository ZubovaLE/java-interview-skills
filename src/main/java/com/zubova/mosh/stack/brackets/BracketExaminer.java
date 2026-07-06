package com.zubova.mosh.stack.brackets;

import java.util.Map;
import java.util.Stack;

public class BracketExaminer {

    private static final Map<Character, Character> BRACKETS_MAP = Map.of(
            ')', '(',
            '}', '{',
            ']', '[',
            '>', '<'
    );

    public boolean isBalanced(String input) {
        Stack<Character> leftBrackets = new Stack<>();
        for (char ch : input.toCharArray()) {
            if (BRACKETS_MAP.containsValue(ch)) {
                leftBrackets.push(ch);
                continue;
            }
            if (BRACKETS_MAP.containsKey(ch)) {
                if (leftBrackets.isEmpty()) {
                    return false;
                }
                if (leftBrackets.peek().equals(BRACKETS_MAP.get(ch))) {
                    leftBrackets.pop();
                } else {
                    return false;
                }
            }
        }
        return leftBrackets.isEmpty();
    }
}
