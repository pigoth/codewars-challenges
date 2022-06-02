package org.example.challenge.domino;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tile tile = (Tile) o;
        return a == tile.a && b == tile.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}

