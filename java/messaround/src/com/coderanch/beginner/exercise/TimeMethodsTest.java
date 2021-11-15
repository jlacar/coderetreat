package com.coderanch.beginner.exercise;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static com.coderanch.beginner.exercise.TimeMethods.*;

class TimeMethodsTest {

    @ParameterizedTest
    @ValueSource(ints = {2012, 2000, 2004, 2008, 1996})
    void leap_years(int year) {
        assertTrue(isLeap(year));
    }

    @ParameterizedTest
    @ValueSource(ints = {2011, 2013, 2019, 1999, 1900, 2100})
    void non_leap_years(int year) {
        assertFalse(isLeap(year));
    }
}