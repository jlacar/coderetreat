package com.coderanch.beginner.exercise.srp;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CourseTest {

    Student sam = new Student();
    Student mary = new Student();

    private Course java101;

    @BeforeEach
    void setup() {
        java101 = new Course();
    }

    @Test
    void
    student_should_be_added_to_new_course_roster() {
        assertTrue(java101.addToRoster(sam));
    }

    @Test
    void
    coarse_should_reject_student_when_already_enrolled() {
        java101.addToRoster(sam);

        assertFalse(java101.addToRoster(sam));
    }

    @Test
    void
    isOnRoster_should_be_false_when_course_is_new() {
        assertFalse(java101.isOnRoster(sam));
        assertFalse(java101.isOnRoster(mary));
    }

    @Test
    void
    isOnRoster_should_be_true_when_student_enrolled() {
        java101.addToRoster(sam);

        assertTrue(java101.isOnRoster(sam));
    }

    @Nested
    class Synchronized_with_Student {

        @Test
        void
        sam_should_be_taking_course_after_getting_added_to_course_roster() {
            java101.addToRoster(sam);
            assertTrue(sam.isTaking(java101));
        }

    }
}