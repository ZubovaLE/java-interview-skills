package com.zubova.module1.string.example;

public class LongestPalindromeFinder {
    public static String longestPalindromeString(String in) {
        char[] input = in.toCharArray();
        int longestPalindromeStart = 0;
        int longestPalindromeEnd = 0;

        for (int mid = 0; mid < input.length; mid++) {
            // Нечётная длина
            int left = mid - 1;
            int right = mid + 1;
            while (left >= 0 && right < input.length) {
                if (input[left] == input[right]) {
                    if (right - left > longestPalindromeEnd - longestPalindromeStart) {
                        longestPalindromeStart = left;
                        longestPalindromeEnd = right;
                    }
                    left--;
                    right++;
                } else {
                    break;
                }
            }

            // Чётная длина
            left = mid;
            right = mid + 1;
            while (left >= 0 && right < input.length) {
                if (input[left] == input[right]) {
                    if (right - left > longestPalindromeEnd - longestPalindromeStart) {
                        longestPalindromeStart = left;
                        longestPalindromeEnd = right;
                    }
                    left--;
                    right++;
                } else {
                    break;
                }
            }
        }

        return in.substring(longestPalindromeStart, longestPalindromeEnd + 1);

    }
}