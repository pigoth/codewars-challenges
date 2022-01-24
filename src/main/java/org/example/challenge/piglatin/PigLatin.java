package org.example.challenge.piglatin;

import java.util.function.Function;

import static java.lang.Character.isLetter;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;

public class PigLatin {

    public static String pigIt(String str) {
        Function<String, String> moveFirstLetterAtTheEnd = word -> word.substring(1) + word.charAt(0);
        return stream(str.split(" "))
                .map(moveFirstLetterAtTheEnd)
                .collect(joining("ay ", "", isLetter(str.charAt(str.length() - 1)) ? "ay" : ""));
    }
}
