package com.coderanch.beginner.exercise;

import java.util.Random;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static com.coderanch.beginner.exercise.Predicates.*;

public enum Keyboard {
    INSTANCE;

    private static final Scanner stdin = new Scanner(System.in);

    public int promptForInt(String prompt, Predicate<Integer> validation) {
        return getValue(prompt, stdin::nextInt, validation);
    }

    public double promptForDouble(String prompt, Predicate<Double> validation) {
        return getValue(prompt, stdin::nextDouble, validation);
    }

    public String promptForString(String prompt, Predicate<String> validation) {
        return getValue(prompt, stdin::nextLine, validation);
    }

    private static <T> T getValue(String prompt, Supplier<T> source, Predicate<T> validation) {
        T value;
        do {
            System.out.print(prompt);
            value = source.get();
        } while (!validation.test(value));
        return value;
    }
}

class TestKeyboard {
    public static void main(String[] args) {
        System.out.println("Hi! This is a guessing game.");
        Keyboard stdin = Keyboard.INSTANCE;
        String player = stdin.promptForString(
                "What's your name? (3-12 chars) ",
                minLength(3).and(maxLength(12))
        );
        System.out.println("I'm thinking of an even number from 2 to 100...");
        int secret = (new Random().nextInt(50) + 1) * 2;
        int count = 0;
        int guess;
        do {
            guess = stdin.promptForInt(
                    "What's your guess? (1..100, even): ",
                    inRange(1, 100).and(divisibleBy(2))
            );
            count++;
            if (guess < secret) {
                System.out.println("Higher");
            } else if (guess > secret) {
                System.out.println("Lower");
            }
        } while (guess != secret);
        System.out.printf("Well done, %s, you got it in %d guesses!%n", player, count);
    }
}
