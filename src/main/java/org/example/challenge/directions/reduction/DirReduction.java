package org.example.challenge.directions.reduction;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;

public class DirReduction {

    public static final String EAST_WEST = "EAST_WEST_";
    public static final String WEST_EAST = "WEST_EAST_";
    public static final String NORTH_SOUTH = "NORTH_SOUTH_";
    public static final String SOUTH_NORTH = "SOUTH_NORTH_";

    public static String[] dirReduc(String[] arr) {
        String directions = reduce(arr);

        while (isReducible(directions))
            directions = reduce(directions.split("_"));

        return directions.length() == 0 ? new String[]{} : directions.split("_");
    }

    private static boolean isReducible(String directions) {
        return directions.contains(EAST_WEST) ||
                directions.contains(WEST_EAST) ||
                directions.contains(NORTH_SOUTH) ||
                directions.contains(SOUTH_NORTH);
    }

    private static String reduce(String[] arr) {
        return stream(arr).collect(joining("_", "", "_"))
                .replace(EAST_WEST, "")
                .replace(WEST_EAST, "")
                .replace(NORTH_SOUTH, "")
                .replace(SOUTH_NORTH, "");
    }
}
