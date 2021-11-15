package com.jlacar;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = i + 1;
        }

        int j = array.length - 1;
        System.out.println(Arrays.toString(array));

        for (int i = 0; i < j; i++) {
            if (array[i] % 2 == 0) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                j--;
            }
            System.out.printf("i = %d, j = %d, array = %s%n", i, j+1, Arrays.toString(array));
        }
    }
}

interface Foo {
    void nothing();
}

class Bar {
    void nothing() {}
}