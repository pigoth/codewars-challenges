package org.example.challenge.domino;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.concat;

public class Chain {
    private final List<Tile> rings;

    public static Chain empty() {
        return new Chain();
    }

    public static Chain of(Tile... tiles) {
        return new Chain(stream(tiles).toList());
    }

    private Chain() {
        rings = new ArrayList<>();
    }

    private Chain(List<Tile> rings) {
        this.rings = rings;
    }

    public boolean canAppend(Tile tile) {
        Tile last = lastTile();
        return rings.isEmpty() || last.right() == tile.left();
    }

    public Chain append(Tile tile) {
        return new Chain(concat(rings.stream(), Stream.of(tile)).collect(toList()));
    }

    public boolean hasMinSize() {
        return rings.size() > 1;
    }

    public boolean contains(Tile tile) {
        return rings.contains(tile);
    }

    @Override
    public int hashCode() {
        return rings != null ? rings.hashCode() : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chain chain = (Chain) o;

        return Objects.equals(rings, chain.rings);
    }

    public Integer weight() {
        return rings.stream()
                .mapToInt(Tile::right)
                .sum() - lastTile().right();
    }

    private Tile lastTile() {
        return rings.get(rings.size() - 1);
    }

}
