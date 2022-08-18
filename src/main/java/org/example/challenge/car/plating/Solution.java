package org.example.challenge.car.plating;

import java.util.stream.Stream;

import static java.lang.String.valueOf;

public class Solution {


    public static String findTheNumberPlate(int customerID) {
        var firstChar = (char) ('a' + (customerID + 1 + (customerID / 999)) / 1000);
        var numeric = (customerID + 1 + (customerID / 999)) % 1000;
        var numericPrefix = "0".repeat(3 - valueOf(numeric).length());

        return firstChar + "aa" + numericPrefix + numeric;
    }
}
