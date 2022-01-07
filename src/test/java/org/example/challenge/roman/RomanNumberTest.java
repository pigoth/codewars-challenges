package org.example.challenge.roman;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


class RomanNumberTest {
    @Test
    void should_return_0_with_empty_roman_number() {
        assertThat(RomanNumber.decode("")).isEqualTo(0);
    }

    @Test
    public void should_evaluate_single_roman_number() {
        assertThat(RomanNumber.decode("I")).isEqualTo(1);
        assertThat(RomanNumber.decode("V")).isEqualTo(5);
        assertThat(RomanNumber.decode("X")).isEqualTo(10);
        assertThat(RomanNumber.decode("L")).isEqualTo(50);
        assertThat(RomanNumber.decode("C")).isEqualTo(100);
        assertThat(RomanNumber.decode("D")).isEqualTo(500);
        assertThat(RomanNumber.decode("M")).isEqualTo(1000);
    }

    @Test
    public void should_evaluate_ascending_roman_number() {
        assertThat(RomanNumber.decode("IV")).isEqualTo(4);
        assertThat(RomanNumber.decode("IX")).isEqualTo(9);
        assertThat(RomanNumber.decode("XL")).isEqualTo(40);
        assertThat(RomanNumber.decode("XC")).isEqualTo(90);
        assertThat(RomanNumber.decode("CD")).isEqualTo(400);
        assertThat(RomanNumber.decode("CM")).isEqualTo(900);
    }

    @Test
    public void should_evaluate_composite_roman_number() {
        assertThat(RomanNumber.decode("XI")).isEqualTo(11);
    }

    @Test
    public void should_evaluate_composite_roman_number_with_ascending_case() {
        assertThat(RomanNumber.decode("XIV")).isEqualTo(14);
    }
}
