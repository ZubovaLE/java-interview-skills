package com.zubova.mosh.stack.brackets;

import java.util.Stack;

public class MoshBracketBalancer {

    private static final char LEFT_PARENTHESIS = '(';
    private static final char RIGHT_PARENTHESIS = ')';
    private static final char LEFT_CURLY_BRACE = '{';
    private static final char RIGHT_CURLY_BRACE = '}';
    private static final char LEFT_SQUARE_BRACKET = '[';
    private static final char RIGHT_SQUARE_BRACKET = ']';
    private static final char LEFT_ANGULAR_BRACKET = '<';
    private static final char RIGHT_ANGULAR_BRACKET = '>';

    public boolean isBalanced(String input) {
        Stack<Character> leftBrackets = new Stack<>();
        for (char ch : input.toCharArray()) {
            if (isLeftBracket(ch)) {
                leftBrackets.push(ch);
                continue;
            }
            if (isRightBracket(ch)) {
                if (leftBrackets.isEmpty()) {
                    return false;
                }
                if (!bracketsMatch(leftBrackets.pop(), ch)) {
                    return false;
                }
            }
        }
        return leftBrackets.isEmpty();
    }

    private boolean isLeftBracket(char c) {
        return c == LEFT_PARENTHESIS || c == LEFT_CURLY_BRACE || c == LEFT_SQUARE_BRACKET || c == LEFT_ANGULAR_BRACKET;
    }

    private boolean isRightBracket(char c) {
        return c == RIGHT_PARENTHESIS || c == RIGHT_CURLY_BRACE || c == RIGHT_SQUARE_BRACKET || c == RIGHT_ANGULAR_BRACKET;
    }

    private boolean bracketsMatch(char left, char right) {
        return (left == LEFT_PARENTHESIS && right != RIGHT_PARENTHESIS) ||
                (left == LEFT_CURLY_BRACE && right != RIGHT_CURLY_BRACE) ||
                (left == LEFT_SQUARE_BRACKET && right != RIGHT_SQUARE_BRACKET) ||
                (left == LEFT_ANGULAR_BRACKET && right != RIGHT_ANGULAR_BRACKET);
    }
}
