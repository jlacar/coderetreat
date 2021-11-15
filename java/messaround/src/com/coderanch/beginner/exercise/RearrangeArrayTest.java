package com.coderanch.beginner.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RearrangeArrayTest {

    private RearrangeArray cut = new RearrangeArray();

    @Test
    void missingAreInOriginalOrder() {
        int[] arr = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        cut.reorder(arr, new int[]{2, 1, 4, 3, 9, 6});

        assertArrayEquals(new int[]{2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19}, arr);
    }

    @Test
    void firstIsOutOfOrder() {
        int[] arr = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        cut.reorder(arr, new int[]{1, 2, 4, 3, 9, 6});

        assertArrayEquals(new int[]{1, 2, 2, 2, 4, 3, 3, 9, 6, 7, 19}, arr);
    }

    @Test
    void piets_test() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        cut.reorder(arr, new int[] {3, 5});

        assertArrayEquals(new int[] {3, 5, 1, 2, 4, 6}, arr);
    }

    @Test
    void firstIsMissing() {
        int[] arr = {19, 3, 1, 3, 2, 4, 6, 7, 9, 2, 2};
        cut.reorder(arr, new int[]{1, 2, 4, 3, 9, 6});

        assertArrayEquals(new int[]{1, 2, 2, 2, 4, 3, 3, 9, 6, 19, 7}, arr);
    }

    @Test
    void allAreMissing() {
        int[] arr = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        cut.reorder(arr, new int[]{0, 5});

        assertArrayEquals(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, arr);
    }
}