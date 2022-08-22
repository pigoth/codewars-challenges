package org.example.challenge.string.incrementer;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.String.valueOf;
import static java.math.BigInteger.ONE;

public class Kata {
    public static String incrementString(String str) {
        Matcher results = Pattern.compile("\\d+$").matcher(str);
        if (results.find()) {
            String actualNumber = results.group();
            return str.replaceAll(actualNumber + "$", increment(actualNumber));
        }
        return str + "1";
    }

    private static String increment(String value) {
        var result = new BigInteger(value).add(ONE);
        int paddingSize = value.length() - valueOf(result).length();
        return "0".repeat(paddingSize > 0 ? paddingSize : 0) + result;
    }
}
