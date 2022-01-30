package org.example.challenge.same;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;

public class AreSame {

    public static boolean comp(int[] a, int[] b) {
        return a != null &&
                b != null &&
                a.length == b.length &&
                Arrays.equals(sortedSqrtFrom(b), sort(a));

    }

    private static int[] sort(int[] a) {
        return Arrays.stream(a)
                .map(toPositive())
                .sorted()
                .toArray();
    }

    private static IntUnaryOperator toPositive() {
        return it -> it < 0 ? it * -1 : it;
    }

    private static int[] sortedSqrtFrom(int[] b) {
        return Arrays.stream(b)
                .mapToDouble(it -> it)
                .map(Math::sqrt)
                .mapToInt(it -> (int) it)
                .sorted()
                .toArray();
    }

}
