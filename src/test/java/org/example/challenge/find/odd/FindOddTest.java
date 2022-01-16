package org.example.challenge.find.odd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindOddTest {

    @Test
    void should_find_odd_in_array_with_one_element() {
        assertThat(FindOdd.findIt(new int[]{10})).isEqualTo(10);
    }

    @Test
    void should_find_odd_in_array_with_three_element() {
        assertThat(FindOdd.findIt(new int[]{10, 2, 10})).isEqualTo(2);
    }

    @Test
    void should_find_odd_in_array_with_n_element() {
        assertThat(FindOdd.findIt(new int[]{-1, 2, 10, 2, 3, 3, 10})).isEqualTo(-1);
    }

}
