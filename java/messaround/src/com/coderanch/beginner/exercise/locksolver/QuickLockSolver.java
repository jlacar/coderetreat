package com.coderanch.beginner.exercise.locksolver;

public class QuickLockSolver {
    private final int unlockCombo;

    public QuickLockSolver(int unlockCombo) {
        this.unlockCombo = unlockCombo;
    }

    public boolean isUnlockedWith(int combo) {
        return combo == unlockCombo;
    }
}
