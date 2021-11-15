package com.coderanch.beginner.exercise.srp;

import java.util.HashSet;
import java.util.Set;

public class Student {
    private Set<Course> coarseLoad = new HashSet<>();

    boolean enrollIn(Course newCoarse) {
        if (coarseLoad.contains(newCoarse)) {
            return false;
        }
        return newCoarse.addToRoster(this);
    }

    void confirmEnrollment(Course course) {
        if (course.isOnRoster(this)) {
            coarseLoad.add(course);
        } else {
            coarseLoad.remove(course);
        }
    }

    public boolean isTaking(Course course) {
        return coarseLoad.contains(course);
    }
}
