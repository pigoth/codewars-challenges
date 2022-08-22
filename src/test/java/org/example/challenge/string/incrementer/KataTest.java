package org.example.challenge.string.incrementer;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @Test
    public void exampleTests() {
        assertThat(Kata.incrementString("")).isEqualTo("1");
        assertThat(Kata.incrementString("foo")).isEqualTo("foo1");
        assertThat(Kata.incrementString("foobar99")).isEqualTo("foobar100");
        assertThat(Kata.incrementString("foobar000")).isEqualTo("foobar001");
        assertThat(Kata.incrementString("foobar001")).isEqualTo("foobar002");
        assertThat(Kata.incrementString("foobar099")).isEqualTo("foobar100");
        assertThat(Kata.incrementString("fo99obar100")).isEqualTo("fo99obar101");
        assertThat(Kata.incrementString("fo100obar100")).isEqualTo("fo100obar101");
        assertThat(Kata.incrementString("144658654495668506869")).isEqualTo("144658654495668506870");
    }


}
