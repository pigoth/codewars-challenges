package org.example.challenge.dominoes;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DominoesTest {

    @Test
    void should_return_max_as_0_when_chain_is_less_than_two_tail() {
        assertThat(Dominoes.of(emptyList()).max()).isEqualTo(0);
        assertThat(Dominoes.of(of(new Tail(1, 2))).max()).isEqualTo(0);
    }
}
