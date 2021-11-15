package com.coderanch.beginner.exercise;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Riffle shuffling an array")
class RiffleTest {

    @Nested
    @DisplayName("when it has an even number of elements")
    class EvenSized {

        @Test
        @DisplayName("should interleave elements in first half with those in the second")
        void riffle() {
            assertArrayEquals(arrayOf(1, 3, 2, 4),
                    Riffle.shuffle(arrayOf(1, 2, 3, 4)));
        }
    }

    @Nested
    @DisplayName(("when it has an odd number of elements"))
    class OddSized {
        @Test
        @DisplayName("should interleave elements with second half being smaller by one element")
        void riffle() {
            assertArrayEquals(arrayOf(1, 4, 2, 5, 3),
                    Riffle.shuffle(arrayOf(1, 2, 3, 4, 5)));
        }
    }

    @Nested
    @DisplayName("when it has minimal number of elements")
    class CornerCases {

        private final int[] EMPTY_ARRAY = new int[] {};

        @Test
        @DisplayName("Case: less than 3 elements, remains unchanged")
        void oneElement() {
            assertArrayEquals(EMPTY_ARRAY, Riffle.shuffle(EMPTY_ARRAY));
            assertArrayEquals(arrayOf(1), Riffle.shuffle(arrayOf(1)));
            assertArrayEquals(arrayOf(1, 2), Riffle.shuffle(arrayOf(1, 2)));
        }

        @Test
        @DisplayName("Case: only three elements, riffled array starts with element from first half")
        public void starts_with_first_half_element() {
            assertArrayEquals(arrayOf(1, 3, 2),
                    Riffle.shuffle(arrayOf(1, 2, 3)));
        }
    }

    private static int[] arrayOf(int... numbers) {
        return numbers;
    }
}