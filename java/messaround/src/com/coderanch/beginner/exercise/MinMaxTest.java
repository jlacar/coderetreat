package com.coderanch.beginner.exercise;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.coderanch.beginner.exercise.MinMax.max;
import static com.coderanch.beginner.exercise.MinMax.min;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxTest {
    private static int[] arrayOf(int... numbers) {
        return numbers;
    }

    @Nested
    class Min {
        @Test
        void allPositiveNumbers() {
            assertEquals(1, min(arrayOf(4, 1, 10, 9)));
        }

        @Test
        void withNegativeNumbers() {
            assertEquals(-10, min(arrayOf(5, -2, 0, -10, -8, 20)));
        }


    }

    @Nested
    class Max {
        @Test
        void allPositiveNumbers() {
            assertEquals(10, max(arrayOf(4, 1, 10, 9)));
        }

        @Test
        void withNegativeNumbers() {
            assertEquals(20, max(arrayOf(5, -2, 0, 10, -8, 20)));
        }
    }
}