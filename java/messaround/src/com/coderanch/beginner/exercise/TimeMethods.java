package com.coderanch.beginner.exercise;

public class TimeMethods {

    public static boolean isLeap(int year) {
        return year % 400 == 0 || year % 100 != 0 && year % 4 == 0;
//        return (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));
    }
}
