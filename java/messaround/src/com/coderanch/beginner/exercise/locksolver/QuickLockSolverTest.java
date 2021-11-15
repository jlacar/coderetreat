package com.coderanch.beginner.exercise.locksolver;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickLockSolverTest {

    @Test
    @DisplayName("Accepts the unlock combination in constructor")
    void instantiate_with_combo() {
        QuickLockSolver solver = new QuickLockSolver(1234);
        assertTrue(solver.isUnlockedWith(1234));
    }

    @Test
    @DisplayName("")
    void name() {
    }
}