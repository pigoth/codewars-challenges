package org.example.challenge.hamming.code;


import com.google.common.base.Splitter;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;

public class CodeWars {

    public String encode(String text) {
       return text.chars()
                .mapToObj(Integer::toBinaryString)
                .map(binary -> "0".repeat(8 - binary.length()) + binary)
                .map(binary -> stream(binary.split("")).map(bit -> bit.repeat(3)).collect(joining()))
                .collect(joining());
    }

    public String decode(String bits) {
        String bytes = splitString(bits, 3)
                .map(triple -> stream(triple.split("")).filter(bit -> bit.equals("0")).count() > 1 ? "0" : "1")
                .collect(joining());

        return splitString(bytes, 8)
                .map(binaryString -> parseInt(binaryString, 2))
                .map(characterCode -> (char)((int)characterCode))
                .map(String::valueOf)
                .collect(joining());
    }

    private static Stream<String> splitString(String bits, int length) {
        return StreamSupport.stream(Splitter.fixedLength(length).split(bits).spliterator(), false);
    }

}
