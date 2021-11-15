package com.coderanch.beginner.exercise.srp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudentTest {

    private Course java101;
    private Student sam;

    @BeforeEach
    void setup() {
        java101 = new Course();
        sam = new Student();
    }

    @Test
    void
    should_be_on_course_roster_when_enrolled() {
        sam.enrollIn(java101);
        assertTrue(java101.isOnRoster(sam));
    }

    @Test
    void
    isTaking_should_be_true_after_enrolling() {
        sam.enrollIn(java101);
        assertTrue(sam.isTaking(java101));
    }
}