package com.coderanch.beginner.exercise;

import java.util.Arrays;
import java.util.function.IntConsumer;

public class MinMax {
    public static int min(int[] numbers) {
        return Arrays.stream(numbers).min().orElseThrow(IllegalArgumentException::new);
    }

    public static int max(int[] numbers) {
        return Arrays.stream(numbers).max().orElseThrow(IllegalArgumentException::new);
    }

    // Get the maximum sum of all subsequences of numbers
    public static int maxSequence(int[] numbers) {
        Kadane kadane = new Kadane();
        Arrays.stream(numbers).forEachOrdered(kadane);
        return kadane.best;
    }
}

// Encapsulates Kadane's algorithm for max subsequence
class Kadane implements IntConsumer {
    int best = 0;
    int sumToThis = 0;

    @Override
    public void accept(int value) {
        sumToThis = Math.max(0, sumToThis + value);
        best = Math.max(best, sumToThis);
    }
}
