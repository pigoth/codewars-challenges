package org.example.challenge.domino;

import java.util.Objects;

public class Tile {
    private final int left;
    private final int right;

    public static Tile of(int left, int right) {
        return new Tile(left, right);
    }

    private Tile(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public int left() {
        return left;
    }

    public int right() {
        return right;
    }

    public Tile flip() {
        return new Tile(right, left);
    }

    @Override
    public String toString() {
        return "[" + left + "/" + right + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tile tile = (Tile) o;
        return left == tile.left && right == tile.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}

