package org.example.challenge.humanreadeabletime;

import java.util.ArrayList;

import static java.util.stream.Collectors.joining;
import static java.util.stream.IntStream.range;

public class TimeFormatter {

    public static final int MINUTE = 60;
    public static final int HOUR = 3600;
    public static final int DAY = 24 * HOUR;
    public static final int YEAR = DAY * 365;

    public static String formatDuration(int totalSeconds) {
        if (totalSeconds == 0) return "now";

        ArrayList<String> time = new ArrayList<>();

        int years = totalSeconds / YEAR;
        if (years == 1) time.add(years + " year");
        else if (years > 1) time.add(years + " years");

        int days = (totalSeconds % YEAR) / DAY;
        if (days == 1) time.add(days + " day");
        else if (days > 1) time.add(days + " days");

        int hours = (totalSeconds % DAY) / HOUR;
        if (hours == 1) time.add(hours + " hour");
        else if (hours > 1) time.add(hours + " hours");

        int minutes = (totalSeconds % HOUR) / MINUTE;
        if (minutes == 1) time.add(minutes + " minute");
        else if (minutes > 1) time.add(minutes + " minutes");

        int seconds = totalSeconds % MINUTE;
        if (seconds == 1) time.add(seconds + " second");
        else if (seconds > 1) time.add(seconds + " seconds");

        return joinTime(time);
    }

    private static String joinTime(ArrayList<String> time) {
        int lastPosition = time.size() - 1;
        return range(0, time.size())
                .mapToObj(position -> time.get(position) + delimiter(position, lastPosition))
                .collect(joining());
    }

    private static String delimiter(int position, int last) {
        if (position == last) return "";
        else if (position == last - 1) return " and ";
        else return ", ";
    }

}
