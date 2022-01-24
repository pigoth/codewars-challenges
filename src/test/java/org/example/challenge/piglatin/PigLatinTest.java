package org.example.challenge.piglatin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PigLatinTest {
    @Test
    public void phrase() {
        assertEquals("hisTay siay ymay tringsay", PigLatin.pigIt("This is my string"));
    }

    @Test
    public void phrase_with_ending_punctuation() {
        assertEquals("hisTay siay ymay tringsay .", PigLatin.pigIt("This is my string ."));
    }
}
