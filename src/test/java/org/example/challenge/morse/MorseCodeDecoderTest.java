package org.example.challenge.morse;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MorseCodeDecoderTest {

    @Test
    public void should_decode_single_word() {
        assertThat(MorseCodeDecoder.decode(".... . -.--")).isEqualTo("HEY");
    }

    @Test
    public void should_decode_many_words() {
        assertThat(MorseCodeDecoder.decode(".... . -.--   .--- ..- -.. .")).isEqualTo("HEY JUDE");
    }
}
