package org.example.challenge.smaller;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SmallerTest {

    @Test
    void sorted_desc_case() {
        assertThat(Smaller.smaller(new int[]{5, 4, 3, 2, 1})).containsExactly(4, 3, 2, 1, 0);
    }

    @Test
    void order_case() {
        assertThat(Smaller.smaller(new int[]{1, 2, 3})).containsExactly(0, 0, 0);
    }

    @Test
    void unordered_case() {
        assertThat(Smaller.smaller(new int[]{1, 2, 0})).containsExactly(1, 1, 0);
    }

}
