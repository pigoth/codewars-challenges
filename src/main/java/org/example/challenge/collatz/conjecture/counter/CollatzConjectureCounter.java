package org.example.challenge.collatz.conjecture.counter;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.valueOf;

public class CollatzConjectureCounter {

    public static long countCollatzNumbers(BigInteger number) {
        long counter = 0;

        while (isGreaterThanOne(number)) {
            boolean isOdd = number.testBit(0);
            number = isOdd ? oddCase(number) : evenCase(number);
            counter += 1;
        }
        return counter;
    }

    private static BigInteger evenCase(BigInteger number) {
        return number.divide(valueOf(2));
    }

    private static BigInteger oddCase(BigInteger number) {
        return number.multiply(valueOf(3)).add(valueOf(1));
    }

    private static boolean isGreaterThanOne(BigInteger number) {
        return number.compareTo(ONE) == 1;
    }
}
