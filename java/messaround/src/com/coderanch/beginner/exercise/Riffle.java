package com.coderanch.beginner.exercise;

import java.util.Arrays;

public class Riffle {

    public static int[] shuffle(int[] deck) {
        int[] riffled = Arrays.copyOf(deck, deck.length);
        int half = deck.length / 2 + (deck.length % 2 == 0 ? 0 : 1);
        for (int i = 0, j = 0; i < half; i++, j += 2) {
            riffled[j] = deck[i];
            if (j+1 < deck.length) {
                riffled[j+1] = deck[half + i];
            }
        }
        return riffled;
    }
}
