package org.example.challenge.dominoes;

import org.junit.jupiter.api.Test;

import static java.util.Collections.emptyList;
import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.example.challenge.dominoes.Dominoes.of;

class DominoesTest {

    @Test
    void should_return_max_as_0_when_chain_is_less_than_two_tail() {
        assertThat(of(new Tail(1, 2), emptyList()).max()).isEqualTo(0);
    }

    @Test
    void should_return_max_as_connection_right_to_left_value_when_exist_a_chain_with_two_tails() {
        Dominoes dominoes = of(new Tail(1, 2), of(new Tail(2, 3)));

        assertThat(dominoes.max()).isEqualTo(2);
    }

    @Test
    void should_return_max_as_connection_right_to_right_value_when_exist_a_chain_with_two_tails() {
        Dominoes dominoes = of(new Tail(1, 2), of(new Tail(2, 3)));

        assertThat(dominoes.max()).isEqualTo(2);
    }

    @Test
    void should_return_max_as_connection_left_to_left_value_when_exist_a_chain_with_two_tails() {
        Dominoes dominoes = of(new Tail(2, 1), of(new Tail(2, 3)));

        assertThat(dominoes.max()).isEqualTo(2);
    }

    @Test
    void should_return_max_as_connection_left_to_right_value_when_exist_a_chain_with_two_tails() {
        Dominoes dominoes = of(new Tail(2, 1), of(new Tail(3, 2)));

        assertThat(dominoes.max()).isEqualTo(2);
    }

    @Test
    void should_return_max_as_the_sum_of_middle_value_in_chain() {
        Dominoes dominoes = of(new Tail(1, 2), of(new Tail(3, 4), new Tail(2, 3)));

        assertThat(dominoes.max()).isEqualTo(2 + 3);
    }
}
