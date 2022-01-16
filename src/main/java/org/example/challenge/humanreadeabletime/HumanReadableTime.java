package org.example.challenge.humanreadeabletime;

import static java.lang.String.valueOf;

public class HumanReadableTime {
    public static String makeReadable(int seconds) {
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        return twoDigit(hours) + ":" + twoDigit(minutes) + ":" + twoDigit( seconds % 60);
    }

    private static String twoDigit(int time) {
        return time < 10 ? "0" + time : valueOf(time);
    }
}
