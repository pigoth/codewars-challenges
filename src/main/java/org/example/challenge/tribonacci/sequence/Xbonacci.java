package org.example.challenge.tribonacci.sequence;

import static java.lang.Math.min;

public class Xbonacci {
    public double[] tribonacci(double[] input, int size) {
        if (size == 0) return new double[]{};

        double[] result = new double[size];
        System.arraycopy(input, 0, result, 0, min(input.length, size));
        for (int i = 3; i < size ; i++) {
            result[i] = result[i-1] + result [i-2] + result[i-3];
        }
        return result;
    }

}
