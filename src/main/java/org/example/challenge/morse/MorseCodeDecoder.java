package org.example.challenge.morse;


import java.util.AbstractMap.SimpleEntry;
import java.util.Map;

import static java.util.Map.ofEntries;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;

public class MorseCodeDecoder {

    public static final String MORSE_WORD_SEPARATOR = "   ";
    public static final String MORSE_CHAR_SEPARATOR = " ";
    static Map<String, String> MorseCode = ofEntries(
            new SimpleEntry(".-", "a"),
            new SimpleEntry("-...", "b"),
            new SimpleEntry("-.-.", "c"),
            new SimpleEntry("-..", "d"),
            new SimpleEntry(".", "e"),
            new SimpleEntry("..-.", "f"),
            new SimpleEntry("--.", "g"),
            new SimpleEntry("....", "h"),
            new SimpleEntry("..", "i"),
            new SimpleEntry(".---", "j"),
            new SimpleEntry("-.-", "k"),
            new SimpleEntry(".-..", "l"),
            new SimpleEntry("--", "m"),
            new SimpleEntry("-.", "n"),
            new SimpleEntry("---", "o"),
            new SimpleEntry(".--.", "p"),
            new SimpleEntry("--.-", "q"),
            new SimpleEntry(".-.", "r"),
            new SimpleEntry("...", "s"),
            new SimpleEntry("-", "t"),
            new SimpleEntry("..-", "u"),
            new SimpleEntry("...-", "v"),
            new SimpleEntry(".--", "w"),
            new SimpleEntry("-..-", "x"),
            new SimpleEntry("-.--", "y"),
            new SimpleEntry("--..", "z"),
            new SimpleEntry("|", " ")
    );

    public static String decode(String morsePhrase) {
        return stream(morsePhrase.trim().split(MORSE_WORD_SEPARATOR))
                .map(morseWord -> stream(morseWord.split(MORSE_CHAR_SEPARATOR))
                        .map(MorseCode::get)
                        .collect(joining()))
                .collect(joining(" "));
    }

}
