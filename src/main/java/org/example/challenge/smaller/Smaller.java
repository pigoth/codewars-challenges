package org.example.challenge.smaller;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Smaller {

    public static int[] smaller(int[] unsorted) {
        return IntStream.range(0, unsorted.length)
                .map(position -> {
                    int currentValue = unsorted[position];
                    return (int) Arrays.stream(unsorted, position + 1, unsorted.length)
                            .filter(value -> currentValue > value)
                            .count();
                }).toArray();
    }
}
