package com.codewars;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class SplitterTest {

    private static final String expr = "(?<=\\G.{2})";
    private static final Pattern byPairs = Pattern.compile(expr);

    @ParameterizedTest(name="\"{0}\" should be split as [{1}]")
    @CsvSource({
            "a, a",
            "ab, ab",
            "abc, ab/c",
            "abcd, ab/cd",
            "abcde, ab/cd/e",
            "abcdef, ab/cd/ef"
    })
    void split_is_symmetrical(String s, String pairs) {
        String[] expectedPairs = pairs.split("/");
        assertAll(
            () -> assertArrayEquals(expectedPairs, s.split(expr)),
            () -> assertArrayEquals(expectedPairs, byPairs.split(s))
        );
    }
}