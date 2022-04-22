package org.example.challenge.association;

import java.time.LocalTime;
import java.util.stream.IntStream;

import static java.lang.String.join;
import static java.time.LocalTime.ofSecondOfDay;
import static java.time.format.DateTimeFormatter.ofPattern;
import static java.util.Arrays.asList;
import static java.util.Arrays.stream;

public class Stat {

    public static String stat(String strg) {
        if (strg.isEmpty()) return "";

        return join(" ", asList("Range:", range(strg), "Average:", average(strg), "Median:", median(strg)));
    }

    private static String range(String input) {
        Integer maxSeconds = secondsOfDay(input).max().getAsInt();
        Integer minSeconds = secondsOfDay(input).min().getAsInt();
        return format(maxSeconds - minSeconds);
    }

    private static String average(String input) {
        return format((int) secondsOfDay(input).average().getAsDouble());
    }

    private static String median(String input) {
        int[] seconds = secondsOfDay(input).sorted().toArray();
        int middleIndex = (int) stream(seconds).count() / 2;
        int medianSeconds = seconds.length % 2 != 0 ? seconds[middleIndex] : (seconds[middleIndex] + seconds[middleIndex - 1]) / 2;
        return format(medianSeconds);
    }

    private static IntStream secondsOfDay(String input) {
        return stream(input.split(", "))
                .map(Stat::time)
                .map(it -> LocalTime.of(it[0], it[1], it[2]))
                .mapToInt(LocalTime::toSecondOfDay);
    }

    private static String format(Integer seconds) {
        return ofSecondOfDay(seconds).format(ofPattern("HH|mm|ss"));
    }

    private static int[] time(String result) {
        return stream(result.split("\\|")).mapToInt(Integer::parseInt).toArray();
    }
}
