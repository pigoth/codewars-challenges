package org.example.challenge.base64;

import com.google.common.base.Splitter;

import java.util.stream.Stream;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;
import static java.util.stream.Collectors.joining;
import static java.util.stream.StreamSupport.stream;

public class Base64 {

    private final static String BASE_64_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    public static final String PADDING = "=";

    public static String encode(String input) {
        return sextetsFrom(bitsFrom(input))
                .map(Base64::sextetToBase64CharPosition)
                .map(position -> base64charIn(position))
                .collect(joining()) + paddingFor(input);

    }

    private static int sextetToBase64CharPosition(String sextet) {
        return parseInt(sextet, 2);
    }

    private static String base64charIn(Integer position) {
        return valueOf(BASE_64_CHARS.charAt(position));
    }

    private static Stream<String> sextetsFrom(String bits) {
        return stream(Splitter.fixedLength(6).split(bits).spliterator(), false)
                .map(sextet -> {
                    int notSignificantBitToAdd = 6 - sextet.length() % 6;
                    return sextet.length() == 6 ? sextet : sextet + "0".repeat(notSignificantBitToAdd);
                });
    }

    private static String paddingFor(String input) {
        boolean isMultipleOfThree = input.length() % 3 == 0;
        return isMultipleOfThree ? "" : PADDING.repeat(3 - input.length() % 3);
    }

    private static String bitsFrom(String input) {
        byte[] bytes = input.getBytes();
        StringBuilder bites = new StringBuilder();
        for (byte aByte : bytes) {
            bites.append(octectFrom(aByte));
        }
        return bites.toString();
    }

    private static String octectFrom(byte aByte) {
        String binary = Integer.toBinaryString(aByte);
        int notSignificantBitToAdd = 8 - binary.length() % 8;
        return "0".repeat(notSignificantBitToAdd) + binary;
    }
}
