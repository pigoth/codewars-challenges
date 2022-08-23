package org.example.challenge.tribonacci.sequence;

import static java.util.Arrays.stream;
import static java.util.stream.Stream.concat;
import static java.util.stream.Stream.of;

public class Xbonacci {
    public double[] tribonacci(double[] input, int size) {
        if (size == 0) return new double[] {};

        double sum = stream(input).skip(input.length - 3).sum();

        double[] result = concat(stream(input).boxed(), of(sum))
                .mapToDouble(Double::doubleValue)
                .toArray();

        return result.length == size ? result : tribonacci(result, size);
    }
}
