package org.example.challenge.bouncycaste;

public class BouncingBall {

    public static int bouncingBall(double height, double bounce, double window) {
        if (invalidHeight(height) || invalidBounce(bounce) || invalidWindow(window, height)) return -1;

        return 0;
    }

    private static boolean invalidWindow(double window, double height) {
        return window > height;
    }

    private static boolean invalidBounce(double bounce) {
        return bounce <= 0.0 || bounce >= 1.0;
    }

    private static boolean invalidHeight(double height) {
        return height <= 0.0;
    }
}
