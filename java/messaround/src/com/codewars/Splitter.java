package com.codewars;

import java.util.regex.Pattern;

public class Splitter {
    private static final Pattern BY_PAIRS = Pattern.compile("(?<=\\G.{2})");
    public static String[] splitByPairs(String s) {
        return BY_PAIRS.split(s);
    }
}
