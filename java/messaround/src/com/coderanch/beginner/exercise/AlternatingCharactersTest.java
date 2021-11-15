package com.coderanch.beginner.exercise;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.coderanch.beginner.exercise.AlternatingCharacters.isAlternating;
import static org.junit.jupiter.api.Assertions.*;

class AlternatingCharactersTest {

    @Nested
    class FewerThanTwoCharacters {
        @Test
        void true_for_empty_string() {
            assertTrue(isAlternating(""));
        }

        @ParameterizedTest
        @ValueSource(strings = {"a", "b", "x"})
        void true_for_single_character(String s) {
            assertTrue(isAlternating(s));
        }
    }

    @Nested
    class ExactlyTwoCharacters {
        @ParameterizedTest
        @ValueSource(strings = {"ab", "ac", "xy"})
        void true_when_different(String s) {
            assertTrue(isAlternating(s));
        }

        @ParameterizedTest
        @ValueSource(strings = {"aa", "bb", "xx"})
        void false_when_same(String s) {
            assertFalse(isAlternating(s));
        }
    }

    @Nested
    class MoreThanTwoCharacters {
        @Nested
        class Should_be_true_when {
            @Test
            void three_alternating() {
                assertTrue(isAlternating("aba"));
            }

            @Test
            void four_alternating() {
                assertTrue(isAlternating("abab"));
            }

            @ParameterizedTest
            @ValueSource(strings = {"ababa", "babab", "acaca", "xyxyx"})
            void long_alternating(String initial) {
                String s = initial;
                for (int i = 0; i < 100; i++) {
                     s += s.charAt(s.length() % 2 == 0 ? 0 : 1);
                    assertTrue(isAlternating(s));
                }
            }
        }

        @Nested
        class Should_be_false_when {
            @ParameterizedTest
            @ValueSource(strings = {
                    "aaa", "aab", "abb", "xyz",
                    "aaaa", "aaab", "aabb", "abbb", "wxyz"})
            void not_alternating(String s) {
                assertFalse(isAlternating(s));
            }

            @ParameterizedTest
            @ValueSource(strings = {"ababa", "babab", "acaca", "xyxyx"})
            void long_non_alternating(String initial) {
                String s = initial;
                for (int i = 0; i < 100; i++) {
                    s += s.charAt(s.length() % 2 == 0 ? 0 : 1);
                    assertFalse(isAlternating(s + s.charAt(s.length() - 1)));
                }
            }
        }
    }
}