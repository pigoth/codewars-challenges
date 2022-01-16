package org.example.challenge.collatz.conjecture.counter;

import org.junit.jupiter.api.Test;

import static java.math.BigInteger.valueOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.example.challenge.collatz.conjecture.counter.CollatzConjectureCounter.countCollatzNumbers;

class CollatzConjectureCounterTest {
    @Test
    void should_return_0_when_input_is_one() {
        assertThat(countCollatzNumbers(valueOf(1))).isEqualTo(0L);
    }

    @Test
    void should_divide_by_two_when_even_and_count_the_iteration() {
        assertThat(countCollatzNumbers(valueOf(2))).isEqualTo(1L);
    }

    @Test
    void should__when_even_and_count_the_iteration() {
        assertThat(countCollatzNumbers(valueOf(3))).isEqualTo(7L);
    }

}
