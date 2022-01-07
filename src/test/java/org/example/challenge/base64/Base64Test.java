package org.example.challenge.base64;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Base64Test {

    @Test
    void should_encode_without_padding_string_with_length_multiple_of_three() {
        assertThat(Base64.encode("Man")).isEqualTo("TWFu");
    }

    @Test
    void should_encode_with_single_padding_string_with_length_not_multiple_of_three_for_one_char() {
        assertThat(Base64.encode("light work.")).isEqualTo("bGlnaHQgd29yay4=");
    }

    @Test
    void should_encode_with_double_padding_string_with_length_not_multiple_of_three_for_two_chars() {
        assertThat(Base64.encode("light w")).isEqualTo("bGlnaHQgdw==");
    }

}
