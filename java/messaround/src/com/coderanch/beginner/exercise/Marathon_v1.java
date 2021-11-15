package com.coderanch.beginner.exercise;

import java.util.Arrays;
 
class Marathon_v1 {
 
 
    public static void main(String[] arguments) {
        String[] names = {
                "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex",
                "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda",
                "Aaron", "Kate"
        };
 
        int[] times = {
                265, 243, 278, 329, 445, 202, 388, 275, 341, 334, 412, 393, 299,
                343, 317, 273
        };
 
        Integer[] time = new Integer[times.length];
        for (int i = 0; i < times.length; i++) {
            time[i] = times[i];
        }
 
 
        int indexOfBestRunner = bestRunner(time);
        System.out.println("Index of the fastest runner is " + indexOfBestRunner);
        System.out.println("The fastest runner is " + names[indexOfBestRunner] + " with a time of "
                + times[indexOfBestRunner] + " minutes");
 
        int indexOfSecondBestRunner = secondBestRunner(time);
        System.out.println("The index of the second fastest runner is " + indexOfSecondBestRunner);
        System.out.println("The second fastest runner is " + names[indexOfSecondBestRunner] + " with a time of "
                + times[indexOfSecondBestRunner] + " minutes");
 
    } // end of main method


    public static int bestRunner(Integer[] time) {
        int index = 0;
        int fastest = time[index];
        while (++index != (time.length)) {
            if (fastest > time[index]) {
                fastest = time[index];
            }
        }
        return Arrays.asList(time).indexOf(fastest);
    }

    public static int secondBestRunner(Integer[] time) {
        int index = 0;
        int secondFastest = time[index];
        int indexBestRunner = bestRunner(time);
        while (++index != time.length) {
            if (secondFastest == time[indexBestRunner]) {
                secondFastest = time[++index];
                continue;
            } else if (secondFastest > time[index]) {
                secondFastest = time[index];
            }
        }
        return Arrays.asList(time).indexOf(secondFastest);

//        int fastest = bestRunner(time);
//        int second = (fastest == 0) ? 1 : 0;
//        int current = second;
//        while (++current < time.length) {
//            if (current == fastest) continue;
//            if (time[current] < time[second]) {
//                second = current;
//            }
//        }
//        return second;
    }
 
} // end of class