package com.coderanch.beginner.exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumOfTwo {

    public static void main(String[] args) {
        test(9, 0, 1, 2, 7, 3, 1);
        test(14, 1, 2, 0, 7, 7, 8, 17);
    }

    private static void test(int sum, int first, int second, int... nums) {
        int[] result = indicesOfAddends(sum, nums);
        System.out.printf("sum=%d, nums=%s, run=%s, %s%n", sum, Arrays.toString(nums), Arrays.toString(result),
                result[0] == first && result[1] == second ? "Pass" : "FAIL");
    }

    private static int[] indicesOfAddends(int sum, int[] nums) {
        Map<Integer, Integer> seen = new HashMap<>();
        int currentIndex = 0;
        for (var addend : nums) {
            var complement = sum - addend;
            if (seen.containsKey(complement)) {
                return new int[] {seen.get(complement), currentIndex};
            }
            seen.put(addend, currentIndex++);
        }
        throw new IllegalArgumentException("No solution found");
    }
}
