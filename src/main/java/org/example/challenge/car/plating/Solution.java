package org.example.challenge.car.plating;

public class Solution {

    public static String findTheNumberPlate(int customerID) {
        var first = customerID / (26 * 26 * 999);
        var second = (customerID % (26 * 26 * 999)) / (26 * 999);
        var third = (customerID % (26 * 999)) / 999;
        var number = customerID % 999;

        return String.format("%c%c%c%03d", (char) (third + 'a'), (char) (second + 'a'), (char) (first + 'a'), 1 + number);
    }
}
