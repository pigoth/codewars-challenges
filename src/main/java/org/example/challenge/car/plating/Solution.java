package org.example.challenge.car.plating;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.String.join;
import static java.lang.String.valueOf;

public class Solution {

    public static String findTheNumberPlate(int customerID) {
        var first = customerID / (26 * 26 * 999);
        var second = (customerID % (26 * 26 * 999)) / (26 * 999);
        var third = (customerID % (26 * 999)) / 999;
        var number = customerID % 999;

        return String.format("%c%c%c%03d", (char) (third + 'a'), (char) (second + 'a'), (char) (first + 'a'), 1 + number);
    }
}
