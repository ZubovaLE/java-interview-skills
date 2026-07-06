package com.zubova.mosh.string;

public class Main {

    public static void main(String[] args) {
//        System.out.println("Count vowels tests:");
//        String s1 = "Hello!";
//        System.out.println(StringUtils.countNumberOfVowels(s1));
//        System.out.println(StringUtils.countVowelsAsMosh(s1));
//        String s2 = "";
//        System.out.println(StringUtils.countNumberOfVowels(s2));
//        System.out.println(StringUtils.countVowelsAsMosh(s2));
//        String s3 = "Hhhh";
//        System.out.println(StringUtils.countNumberOfVowels(s3));
//        System.out.println(StringUtils.countVowelsAsMosh(s3));
//        String s4 = "OOOO";
//        System.out.println(StringUtils.countNumberOfVowels(s4));
//        System.out.println(StringUtils.countVowelsAsMosh(s4));
//        String s5 = "AaEeIiOoUu";
//        System.out.println(StringUtils.countNumberOfVowels(s5));
//        System.out.println(StringUtils.countVowelsAsMosh(s5));
//        String s6 = "   ";
//        System.out.println(StringUtils.countNumberOfVowels(s6));
//        System.out.println(StringUtils.countVowelsAsMosh(s6));
//        String s7 = null;
//        System.out.println(StringUtils.countNumberOfVowels(s7));
//        System.out.println(StringUtils.countVowelsAsMosh(s7));
//
//        System.out.println("\nReversing string tests:");
//        System.out.println(StringUtils.reverse("Abcdef"));
//        System.out.println(StringUtils.reverse(""));
//        System.out.println(StringUtils.reverse(null));
//        System.out.println(StringUtils.reverse("   "));
//        System.out.println(StringUtils.reverse("Bob"));
//
//        System.out.println("\nReversing words tests:");
//        System.out.println(StringUtils.reverseWordUsingStringBuilder("   Trees are beautiful   "));
//        System.out.println(StringUtils.reverseWords("   Trees are beautiful   "));
//        System.out.println(StringUtils.reverseWordUsingStringBuilder(""));
//        System.out.println(StringUtils.reverseWords(""));
//        System.out.println(StringUtils.reverseWordUsingStringBuilder(null));
//        System.out.println(StringUtils.reverseWords(null));
//        System.out.println(StringUtils.reverseWordUsingStringBuilder("   "));
//        System.out.println(StringUtils.reverseWords("   "));
//        System.out.println(StringUtils.reverseWordUsingStringBuilder("Bob is a good man"));
//        System.out.println(StringUtils.reverseWords("Bob is a good man"));
//
//        System.out.println("Rotations tests:");
//        System.out.println(StringUtils.areRotations("ABCD", "DABC"));
//        System.out.println(StringUtils.areRotations("ABCD", "CDAB"));
//        System.out.println(StringUtils.areRotations("ABCD", "BCDA"));
//        System.out.println(StringUtils.areRotations("ABCD", "ADBC"));
//        System.out.println(StringUtils.areRotations("  ABCD  ", " DABC"));
//        System.out.println(StringUtils.areRotations("", ""));
//        System.out.println(StringUtils.areRotations(" ", "   "));
//        System.out.println(StringUtils.areRotations(null, null));
//        System.out.println(StringUtils.areRotations("ABCD", null));
//        System.out.println(StringUtils.areRotations(null, "DABC"));
//        System.out.println(StringUtils.areRotations("ABCD", "DABC1"));
//        System.out.println(StringUtils.areRotations("ABCD", ""));
//
//        System.out.println("Removing duplicates tests:");
//        System.out.println(StringUtils.removeDuplicates("Helloooo!!"));
//        System.out.println(StringUtils.removeDuplicatesAsMosh("Helloooo!!"));
//        System.out.println(StringUtils.removeDuplicates(""));
//        System.out.println(StringUtils.removeDuplicatesAsMosh(""));
//        System.out.println(StringUtils.removeDuplicates( "  "));
//        System.out.println(StringUtils.removeDuplicatesAsMosh("  "));
//        System.out.println(StringUtils.removeDuplicates(null));
//        System.out.println(StringUtils.removeDuplicatesAsMosh(null));
//
//        System.out.println("Frequency tests:");
//        System.out.println(StringUtils.getMaxOccurringChar("Trees"));
//        System.out.println(StringUtils.getMaxOccurringChar("OhhhgH"));
//        System.out.println(StringUtils.getMaxOccurringChar("OHhhHHHH"));
//        System.out.println(StringUtils.getMaxOccurringChar(""));
//        System.out.println(StringUtils.getMaxOccurringChar(null));
//        System.out.println(StringUtils.getMaxOccurringChar("   "));

//        System.out.println("Capitalize first letters tests:");
//        System.out.println(StringUtils.capitalizeWords("trees are beautiful"));
//        System.out.println(StringUtils.capitalizeWords("Trees are Beautiful"));
//        System.out.println(StringUtils.capitalizeWords("trees    are        beautiful  "));
//        System.out.println(StringUtils.capitalizeWords("   trees    are        beautiful  "));
//        System.out.println(StringUtils.capitalizeWords("   TREES    ARE        BEAUTIFUL  "));
//        System.out.println(StringUtils.capitalizeWords("     "));
//        System.out.println(StringUtils.capitalizeWords(null));

//        System.out.println("Anagram tests:");
//        System.out.println(StringUtils.areAnagrams("abcd", "adbc"));
//        System.out.println(StringUtils.areAnagrams("ABCD", "ADBC"));
//        System.out.println(StringUtils.areAnagrams("abcd", "cadb"));
//        System.out.println(StringUtils.areAnagrams("abcd", "abcd"));
//        System.out.println(StringUtils.areAnagrams("ABCd", "ADBC"));
//
//        System.out.println(StringUtils.areAnagrams("ABCd", " "));
//        System.out.println(StringUtils.areAnagrams("ABCd", null));
//        System.out.println(StringUtils.areAnagrams("ABCX", "ADBC"));
//        System.out.println(StringUtils.areAnagrams("abcd", "adbc1"));
//        System.out.println(StringUtils.areAnagrams("abcd", "abce"));

        System.out.println("Palindrome tests:");
        System.out.println(StringUtils.isPalindromeAsMosh("abba"));
        System.out.println(StringUtils.isPalindromeAsMosh("abbA"));
        System.out.println(StringUtils.isPalindromeAsMosh("abcba"));
        System.out.println(StringUtils.isPalindromeAsMosh("abca"));
        System.out.println(StringUtils.isPalindromeAsMosh(""));
        System.out.println(StringUtils.isPalindromeAsMosh(null));
    }
}
