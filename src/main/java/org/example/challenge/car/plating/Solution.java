package org.example.challenge.car.plating;

import java.util.stream.Stream;

import static java.lang.String.valueOf;

public class Solution {


    public static String findTheNumberPlate(int customerID) {
        int charIndex = (customerID + 1 + (customerID / 999)) / 1000;
        System.out.println(charIndex);

        var maxNumberFirstChar = 999 * 26;

        var firstCharIndex = charIndex <= 25 ? charIndex : 0;
        var firstChar = (char) ('a' + firstCharIndex);
        var secondChar = (char) ('a' + (charIndex % 25));

        return String.valueOf(firstChar) + String.valueOf(secondChar) + "a" + numericPlate(customerID);
    }

    private static String numericPlate(int customerID) {
        var numeric = (customerID + 1 + (customerID / 999)) % 1000;
        var numericPrefix = "0".repeat(3 - valueOf(numeric).length());

        return numericPrefix + numeric;
    }
}
