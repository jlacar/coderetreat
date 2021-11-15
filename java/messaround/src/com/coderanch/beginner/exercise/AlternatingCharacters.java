package com.coderanch.beginner.exercise;

public class AlternatingCharacters {
    public static boolean isAlternating(String s) {
        if (s.length() < 2) {
            return true;
        }
        char a = s.charAt(0);
        char b = s.charAt(1);
        return a != b && isAlternating(s.substring(2), a, b);
    }

    private static boolean isAlternating(String s, Character a, Character b) {
        return s.isEmpty() || s.startsWith(a.toString()) && isAlternating(s.substring(1), b, a);
    }
}
