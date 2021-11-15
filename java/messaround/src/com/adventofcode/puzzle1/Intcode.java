package com.adventofcode.puzzle1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Intcode {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("src/day2-input.txt"));
        input.useDelimiter(",");
        List<Integer> numbers = new ArrayList<>();
        while (input.hasNextInt()) {
            numbers.add(input.nextInt());
        }
        intcode(numbers);
        System.out.println(numbers.get(0));
    }

    static void intcode(List<Integer> numbers) {
        for (int offset = 0, opcode = numbers.get(offset);
                opcode != 99; offset += 4) {
            int operand1 = numbers.get(numbers.get(offset + 1));
            int operand2 = numbers.get(numbers.get(offset + 2));
            if (opcode == 1) {
                numbers.set(numbers.get(offset + 3), operand1 + operand2);
            } else if (opcode == 2) {
                numbers.set(numbers.get(offset + 3), operand1 * operand2);
            }
        }
    }
}
