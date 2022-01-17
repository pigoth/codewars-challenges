package org.example.challenge.humanreadeabletime;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TimeFormatterTest {

    @Test
    void single_second() {
        assertThat(TimeFormatter.formatDuration(1)).isEqualTo("1 second");
    }

    @Test
    void many_seconds() {
        assertThat(TimeFormatter.formatDuration(2)).isEqualTo("2 seconds");
    }

    @Test
    void single_minute() {
        assertThat(TimeFormatter.formatDuration(60)).isEqualTo("1 minute");
    }

    @Test
    void many_minutes() {
        assertThat(TimeFormatter.formatDuration(120)).isEqualTo("2 minutes");
    }

    @Test
    void single_hour() {
        assertThat(TimeFormatter.formatDuration(3600)).isEqualTo("1 hour");
    }

    @Test
    void many_hours() {
        assertThat(TimeFormatter.formatDuration(3600*2)).isEqualTo("2 hours");
    }

    @Test
    void single_day() {
        assertThat(TimeFormatter.formatDuration(24*3600)).isEqualTo("1 day");
    }

    @Test
    void many_days() {
        assertThat(TimeFormatter.formatDuration(24*3600*2)).isEqualTo("2 days");
    }

    @Test
    void single_year() {
        assertThat(TimeFormatter.formatDuration(24*3600*365)).isEqualTo("1 year");
    }

    @Test
    void many_years() {
        assertThat(TimeFormatter.formatDuration(24*3600*365*2)).isEqualTo("2 years");
    }

    @Test
    void join_last_time_with_and() {
        assertThat(TimeFormatter.formatDuration(62)).isEqualTo("1 minute and 2 seconds");
    }

    @Test
    void join_time_with_comma() {
        assertThat(TimeFormatter.formatDuration(3662)).isEqualTo("1 hour, 1 minute and 2 seconds");
    }

    @Test
    void now_when_0_seconds() {
        assertThat(TimeFormatter.formatDuration(0)).isEqualTo("now");
    }
}
