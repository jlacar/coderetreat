package com.coderanch.beginner.exercise;

import java.util.*;

import static java.util.Collections.*;

public class RearrangeArray {
    private final OrderingStrategy strategy;

    public RearrangeArray() {
        this.strategy = new JuniluStrategy();
    }

    public RearrangeArray(OrderingStrategy strategy) {
        this.strategy = strategy;
    }

    void reorder(int[] numbers, int[] order) {
        strategy.reorder(numbers, order);
    }
}

interface OrderingStrategy {
    void reorder(int[] numbers, int[] order);
}

class JuniluStrategy implements OrderingStrategy {
    @Override
    public void reorder(int[] numbers, int[] order) {
        int pos = 0;
        for (int n : order) {
            pos = moveDown(n, numbers, pos);
        }
    }

    private int moveDown(int n, int[] numbers, int position) {
        for (int i = position; i < numbers.length; i++) {
            if (numbers[i] == n) {
                int found = numbers[i];
                moveUp(numbers, position, i);
                numbers[position++] = found;
            }
        }
        return position;
    }

    static void moveUp(int[] arr, int lo, int hi) {
        for (int index = hi; index > lo; index--) {
            arr[index] = arr[index - 1];
        }
    }
}

class CareyStrategy1 implements OrderingStrategy {
    @Override
    public void reorder(int[] aryIn, int[] aryOrder) {
        for (int a = 0; a < aryIn.length - 1; a++) {
            for (int b = a + 1; b < aryIn.length; b++) {
                if (indexOf(aryOrder, aryIn[a]) >
                        indexOf(aryOrder, aryIn[b])) {
                    int c = aryIn[a];
                    aryIn[a] = aryIn[b];
                    aryIn[b] = c;
                }
            }
        }
    }

    static int indexOf(int[] ary, int find) {
        for (int i = 0; i < ary.length; i++)
            if (ary[i] == find)
                return i;
        return Integer.MAX_VALUE;
    }
}

class PietStrategy implements OrderingStrategy {
    @Override
    public void reorder(int[] a, int[] b) {
        int[] inBoth = new int[a.length], onlyInA = new int[a.length];
        int indexBoth = 0, indexOnly = 0;
        for (int i : a) {
            if (arrayContainsNumber(b, i)) inBoth[indexBoth++] = i;
            else onlyInA[indexOnly++] = i;
        }
        for (int i = 0; i < indexOnly; i++) inBoth[indexBoth++] = onlyInA[i];

        for (int i = 0; i < a.length; i++) {
            a[i] = inBoth[i];
        }
    }

    private static boolean arrayContainsNumber(int[] array, int number) {
        for (int i : array) if (i == number) return true;
        return false;
    }
}

class CareyStrategy2 implements OrderingStrategy {
    @Override
    public void reorder(int[] numbers, int[] order) {
        List<Integer> list = toList(numbers);
        List<Integer> orderList = toList(order);

        sort(list, (o1, o2) -> {
            int x = indexOf(orderList, o1);
            int y = indexOf(orderList, o2);
            return (x < y) ? -1 : (y > x) ? 1 : 0;
        });

        reorder(numbers, list.listIterator());
    }

    private static int indexOf(List<Integer> list, int n) {
        int index = list.indexOf(n);
        return index == -1 ? list.size() : index;
    }

    private static void reorder(int[] numbers, ListIterator<Integer> it) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = it.next();
        }
    }

    private static List<Integer> toList(int[] ary) {
        List<Integer> list = new ArrayList<>();
        for (int i : ary) {
            list.add(i);
        }
        return list;
    }
}

class DixitPatelStrategy implements OrderingStrategy {

    @Override
    public void reorder(int[] numbers, int[] order) {
        int[] b = new int[numbers.length + order.length];

        int k = 0;
        for (int i = 0; i < order.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (order[i] == numbers[j]) {
                    b[k] = numbers[j];
                    k++;
                }
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            boolean isMatch = false;
            for (int j = 0; j < b.length; j++) {
                if (numbers[i] == b[j]) {
                    isMatch = true;
                    break;
                }
            }

            if (!isMatch) {
                b[k] = numbers[i];
                k++;
            }
        }

        System.out.println(Arrays.toString(b));

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = b[i];
        }
    }
}