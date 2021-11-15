package com.coderanch.beginner.exercise;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class DoubleLinkedListTest {

    private DoubleLinkedList<Integer> numbers = new DoubleLinkedList<>();

    @Test
    void initial_size_should_be_0() {
        assertEquals(0, numbers.size());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void append_should_increase_size_by_1(int size) {
        for (int i = 0; i < size; i++) {
            numbers.append(i + 1);
        }
        assertEquals(size, numbers.size());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void successful_delete_should_decrease_size_by_1(int size) {
        for (int i = 0; i < size; i++) {
            numbers.append(i + 1);
        }
        boolean deleteSucceeded = numbers.delete(size);
        assertAll(
            () -> assertTrue(deleteSucceeded),
            () -> assertEquals(size - 1, numbers.size())
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void unsuccessful_delete_should_not_change_list_size(int size) {
        for (int i = 0; i < size; i++) {
            numbers.append(i + size + 1);
        }
        boolean deleteSucceeded = numbers.delete(size);
        assertAll(
            () -> assertFalse(deleteSucceeded),
            () -> assertEquals(size, numbers.size())
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void delete_should_remove_all_matching_nodes(int data) {
        for (int i = 0; i < 5; i++) {
            numbers.append(i + 1);
        }
        numbers.append(data);
        boolean deleted = numbers.delete(data);
        assertAll(
                () -> assertTrue(deleted),
                () -> assertEquals(4, numbers.size())
        );
    }

    @Test
    void first_should_return_head_value() {
        for (int i = 0; i < 5; i++) {
            numbers.append(i + 1);
        }
        for (int i = 0; i < 5; i++) {
            assertEquals(i + 1, numbers.first());
            numbers.delete(i + 1);
        }
    }

    @Test
    void first_should_be_null_when_empty_list() {
        assertNull(numbers.first());

        for (int i = 0; i < 5; i++) {
            numbers.append(i + 1);
        }
        for (int i = 0; i < 5; i++) {
            numbers.delete(i + 1);
        }
        assertNull(numbers.first());
    }

    @Test
    void last_should_return_tail_value() {
        for (int i = 0; i < 5; i++) {
            numbers.append(i + 1);
        }
        for (int i = 0; i < 5; i++) {
            assertEquals(5 - i, numbers.last());
            numbers.delete(5 - i);
        }
    }
}