package com.coderanch.beginner.exercise;

import java.util.function.Predicate;

public class Predicates {
    private Predicates() {}

    public static Predicate<Integer> inRange(final int fromClosed, final int toClosed) {
        return n -> fromClosed <= n && n <= toClosed;
    }

    public static Predicate<Double> inRange(final double fromClose, final double toClosed) {
        return d -> fromClose <= d && d <= toClosed;
    }

    public static Predicate<Integer> divisibleBy(final int divisor) {
        if (divisor == 0) throw new IllegalArgumentException("Divisor cannot be 0");
        return n -> n % divisor == 0;
    }

    public static Predicate<String> minLength(final int min) {
        return s -> s.length() >= min;
    }

    public static Predicate<String> maxLength(final int max) {
        return s -> s.length() <= max;
    }
}
