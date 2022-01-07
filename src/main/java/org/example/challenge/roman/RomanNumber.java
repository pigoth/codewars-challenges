package org.example.challenge.roman;

import java.util.Map;

class RomanNumber {

    private static final Map<String, Integer> ROMAN_ARABIC_SINGLE_LETTER_MAPPER = Map.ofEntries(
            Map.entry("M", 1000),
            Map.entry("D", 500),
            Map.entry("C", 100),
            Map.entry("L", 50),
            Map.entry("X", 10),
            Map.entry("V", 5),
            Map.entry("I", 1)
    );

    private static final Map<String, Integer> ROMAN_ARABIC_ASCENDING_CASE_MAPPER = Map.ofEntries(
            Map.entry("CM", 900),
            Map.entry("CD", 400),
            Map.entry("XC", 90),
            Map.entry("XL", 40),
            Map.entry("IX", 9),
            Map.entry("IV", 4)
    );

    public static int decode(String roman) {
        if (roman.length() == 0) return 0;

        return arabFrom(roman) + decode(notEvalautedRoman(roman));
    }

    private static String notEvalautedRoman(String roman) {
        return isAscendingCase(roman) ?
                roman.substring(2) :
                roman.substring(1);
    }

    private static Integer arabFrom(String roman) {
        return isAscendingCase(roman) ?
                ROMAN_ARABIC_ASCENDING_CASE_MAPPER.get(roman.substring(0, 2)) :
                ROMAN_ARABIC_SINGLE_LETTER_MAPPER.get(roman.substring(0, 1));
    }

    private static boolean isAscendingCase(String roman) {
        return roman.length() > 1 &&
                ROMAN_ARABIC_ASCENDING_CASE_MAPPER.containsKey(roman.substring(0, 2));
    }

}
