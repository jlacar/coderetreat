package com.adventofcode.puzzle1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class FuelCounterUpper {
    static Scanner input;

    public static void main(String[] args) throws IOException {
        int totalFuel = Files.lines(Paths.get("src/day1-input.txt"))
                .mapToInt(Integer::parseInt)
                .map(FuelCounterUpper::fuel)
                .sum();

        System.out.printf("Fuel is %d%n", totalFuel);
    }

    static int fuel(int mass) {
        int fuel = mass / 3 - 2;
        if (fuel <= 0) {
            return 0;
        }
        return fuel + fuel(fuel);
    }
}
