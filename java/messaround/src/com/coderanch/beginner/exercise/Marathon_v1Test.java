package com.coderanch.beginner.exercise;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.coderanch.beginner.exercise.Marathon_v1.*;
import static org.junit.jupiter.api.Assertions.*;

class Marathon_v1Test {

    @Nested
    @DisplayName("Best runner time")
    class BestRunner {
        @Test
        void best_is_first_element() {
            assertEquals(0, bestRunner(new Integer[] {100, 200, 300}));
        }

        @Test
        void best_is_last_element() {
            assertEquals(2, bestRunner(new Integer[] {300, 200, 100}));
        }

        @Test
        void best_is_middle_element() {
            assertEquals(1, bestRunner(new Integer[] {200, 100, 300}));
        }
    }

    @Nested
    @DisplayName("Second best runner time")
    class SecondBestRunner {
        @Test
        void first_element() {
            assertEquals(0, secondBestRunner(new Integer[]{200, 100, 300}));
        }

        @Test
        void last_element() {
            assertEquals(2, secondBestRunner(new Integer[]{300, 100, 200}));
        }

        @Test
        void middle_element() {
            assertEquals(1, secondBestRunner(new Integer[]{300, 200, 100}));
        }
    }

}