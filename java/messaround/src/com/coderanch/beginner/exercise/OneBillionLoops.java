package com.coderanch.beginner.exercise;

import java.util.stream.LongStream;

public class OneBillionLoops {

    private static int LIMIT = 1_000_000;

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            ifAnd();
            ifOr();
            streamSum();
            mikeSum();
            pietJump();
        }
    }

    private static long streamSum() {
        return LongStream.range(1, LIMIT + 1).filter(i -> i % 3 != 0 && (i / 100) % 10 != 2 && (i / 100) % 10 != 3).sum();
    }

    private static long ifOr() {
        long sum = 0;
        for (int i = 1; i <= LIMIT; i++) {
            if (i % 3 == 0 || (i / 100) % 10 == 2 || (i / 100) % 10 == 3) continue;
            sum += i;
        }
        return sum;
    }

    private static long ifAnd() {
        long sum = 0;
        for (int i = 1; i <= LIMIT; i++) {
            if (i % 3 != 0 && (i / 100) % 10 != 2 && (i / 100) % 10 != 3) {
                sum += i;
            }
        }
        return sum;
    }

    private static long mikeSum() {
        return LongStream.concat(
                LongStream.iterate(1, i -> i <= LIMIT, i -> i += 3),
                LongStream.iterate(2, i -> i <= LIMIT, i -> i += 3)
        ).filter(OneBillionLoops::isHundredsNot2or3)
                .sum();
    }

    private static long pietJump() {
        return LongStream.concat(LongStream.iterate(1L, i -> i <= LIMIT, i -> i + jump(i)),
                LongStream.iterate(2L, i -> i <= LIMIT, i -> i + jump(i))).sum();
    }

    private static long jump(long i) {
        var dif = i % 1000;
        return dif == 197 ? 204 :
               dif == 198 ? 204 :
               dif == 199 ? 201 :
                              3
               ;
    }

    private static boolean isHundredsNot2or3(long i) {
        var h = ((int) i / 100) % 10;
        return h != 2 && h != 3;
    }
}
