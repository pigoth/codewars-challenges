package org.example.challenge.abbreviator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AbbreviatorTest {

    private Abbreviator abbr;

    @BeforeEach
    void setUp() {
        abbr = new Abbreviator();
    }

    @Test
    public void should_not_abbreviate_word_longest_lessor_equal_than_3_chars() {
        assertThat(abbr.abbreviate("are")).isEqualTo("are");
    }

    @Test
    public void should_abbreviate_word_longest_than_3_chars() {
        assertThat(abbr.abbreviate("internationalization")).isEqualTo("i18n");
    }

    @Test
    public void should_abbreviate_a_phrase() {
        assertThat(abbr.abbreviate("are internationalization love")).isEqualTo("are i18n l2e");
    }

    @Test
    public void should_abbreviate_composite_word() {
        assertThat(abbr.abbreviate("are-internationalization*love")).isEqualTo("are-i18n*l2e");
    }

    @Test
    public void should_not_evaluate_punctuation() {
        assertThat(abbr.abbreviate("are, internationalization?")).isEqualTo("are, i18n?");
    }

}
