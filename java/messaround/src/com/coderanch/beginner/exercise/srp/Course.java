package com.coderanch.beginner.exercise.srp;

import java.util.HashSet;
import java.util.Set;

public class Course {
    Set<Student> roster = new HashSet<>();

    boolean addToRoster(Student newStudent) {
        boolean added = roster.add(newStudent);
        newStudent.confirmEnrollment(this);
        return added;
    }

    public boolean isOnRoster(Student student) {
        return roster.contains(student);
    }
}
