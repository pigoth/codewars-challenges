package org.example.challenge.domino;

public class Tile {
    public final int a;
    public final int b;

    public Tile(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public Tile flipped() {
        return new Tile(b, a);
    }

    @Override
    public String toString() {
        return "[" + a + "/" + b + "]";
    }
}

