package org.example.challenge.association;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StatTest {

    @Test
    public void should_return_empty_string_with_empty_input() {
        assertThat(Stat.stat("")).isEqualTo("");
    }

    @Test
    public void should_evaluate_single_input() {
        String expected = "Range: 00|00|00 Average: 00|15|00 Median: 00|15|00";
        assertThat(Stat.stat("0|15|0")).isEqualTo(expected);
    }

    @Test
    public void should_evaluate_median_with_odd_input() {
        String expected = "Range: 01|01|18 Average: 01|38|05 Median: 01|32|34";
        String input = "01|15|59, 1|47|16, 01|17|20, 1|32|34, 2|17|17";
        assertThat(Stat.stat(input)).isEqualTo(expected);
    }

    @Test
    public void should_evaluate_median_with_even_input() {
        String expected = "Range: 00|31|17 Average: 02|25|24 Median: 02|19|40";
        String input = "02|15|59, 2|47|16, 02|17|20, 2|32|34, 2|17|17, 2|22|00";
        assertThat(Stat.stat(input)).isEqualTo(expected);
    }

}
