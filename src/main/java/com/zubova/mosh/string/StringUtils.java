package com.zubova.mosh.string;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringUtils {
    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');
    private static final String SPACE_DELIMITER = " ";
    private static final int ASCII_SIZE = 256;

    public static int countNumberOfVowels(String input) {
        if (input == null) {
            return 0;
        }
        Pattern pattern = Pattern.compile("[aeiouAEIOU]");
        Matcher matcher = pattern.matcher(input);
        int counter = 0;
        while (matcher.find()) {
            counter++;
        }
        return counter;
    }

    public static int countVowelsAsMosh(String input) {
        if (input == null) {
            return 0;
        }
        int counter = 0;
        for (char ch : input.toLowerCase().toCharArray()) {
            if (VOWELS.contains(ch)) {
                counter++;
            }
        }
        return counter;
    }

    public static String reverse(String input) {
        if (input == null) {
            return "";
        }
        return new StringBuilder(input).reverse().toString();
    }

    public static String reverseAsMosh(String input) {
        if (input == null) {
            return "";
        }
        StringBuilder reversed = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed.append(input.charAt(i));
        }
        return reversed.toString();
    }

    // not good
    public static String reverseWordUsingStringBuilder(String input) {
        if (input == null) {
            return "";
        }
        StringBuilder reversed = new StringBuilder(input.length());
        String[] words = input.trim().split(SPACE_DELIMITER);
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i] + SPACE_DELIMITER);
        }
        return reversed.toString().trim();
    }

    public static String reverseWords(String input) {
        if (input == null) {
            return "";
        }
        String[] words = input.trim().split(SPACE_DELIMITER);
        Collections.reverse(Arrays.asList(words));
        return String.join(SPACE_DELIMITER, words);
    }

    public static boolean areRotations(String first, String second) {
        if (first == null || second == null) {
            return false;
        }
        String trimmedFirst = first.trim();
        String trimmedSecond = second.trim();
        return (trimmedFirst.length() == trimmedSecond.length() &&
                (trimmedFirst + trimmedFirst).contains(trimmedSecond));
    }

    public static String removeDuplicates(String input) {
        if (input == null) {
            return "";
        }
        return Arrays.stream(input.split(""))
                .distinct()
                .collect(Collectors.joining(""));
    }

    public static String removeDuplicatesAsMosh(String input) {
        if (input == null) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        Set<Character> uniqueCharacters = new HashSet<>();
        for (char ch : input.toCharArray()) {
            if (!uniqueCharacters.contains(ch)) {
                uniqueCharacters.add(ch);
                result.append(ch);
            }
        }
        return result.toString();
    }

    // Алгоритм с использованием массива для подсчета частот символов ASCII.
    public static char getMaxOccurringChar(String input) {
        validateInput(input);
        int[] frequencies = new int[ASCII_SIZE];
        for (char ch : input.toCharArray()) {
            frequencies[ch]++;
        }
        return findMaxFrequency(frequencies);
    }

    public static String capitalizeWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return "";
        }

        String[] words = sentence.trim().split("\\s+");

        for (int i = 0; i < words.length; i++) {
            words[i] = Character.toUpperCase(words[i].charAt(0)) +
                    words[i].substring(1).toLowerCase();
        }

        return String.join(SPACE_DELIMITER, words);
    }

    public static boolean areAnagrams(String input1, String input2) {
        if (input1 == null || input2 == null) {
            return false;
        }
        if (input1.length() != input2.length()) {
            return false;
        }
        char[] array1 = input1.toLowerCase().toCharArray();
        // O(n logn)
        Arrays.sort(array1);

        char[] array2 = input2.toLowerCase().toCharArray();
        Arrays.sort(array2);

        return Arrays.equals(array1, array2);
    }

    public static boolean areAnagrams2(String input1, String input2) {
        if (input1 == null || input2 == null) {
            return false;
        }
        if (input1.length() != input2.length()) {
            return false;
        }
        final int ENGLISH_ALPHABET = 26;
        int[] frequencies = new int[ENGLISH_ALPHABET];

        input1 = input1.toLowerCase();
        for (int i = 0; i < input1.length(); i++) {
            frequencies[input1.charAt(i) - 'a']++;
        }
        input2 = input2.toLowerCase();
        for (int i = 0; i < input2.length(); i++) {
            int index = input2.charAt(i) - 'a';
            if (frequencies[index] == 0) {
                return false;
            }
            frequencies[index]--;
        }
        return true;
    }

    // not effective for long strings
    public static boolean isPalindrome(String input) {
        validateInput(input);
        return input.equals(reverse(input));
    }

    public static boolean isPalindromeAsMosh(String word) {
        if (word == null) {
            return false;
        }
        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left++) != word.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeOptimized(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    private static void validateInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private static char findMaxFrequency(int[] frequencies) {
        int max = 0;
        char result = ' ';
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] > max) {
                max = frequencies[i];
                result = (char) i;
            }
        }
        return result;
    }
}