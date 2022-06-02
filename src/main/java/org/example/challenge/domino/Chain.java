package org.example.challenge.domino;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;
import static java.util.stream.Stream.concat;

public class Chain {
    private final List<Tile> rings;

    public static Chain empty() {
        return new Chain();
    }

    public static Chain of(Tile... tiles) {
        return new Chain(asList(tiles));
    }

    private Chain() {
        rings = new ArrayList<>();
    }

    private Chain(List<Tile> rings) {
        IntPredicate invalidMatch = index -> index != 0 && rings.get(index - 1).right() != rings.get(index).left();
        if(range(0, rings.size()).anyMatch(invalidMatch)) throw new RuntimeException("Tile not match");

        this.rings = rings;
    }

    public boolean canAppend(Tile tile) {
        return rings.isEmpty() || lastTile().right() == tile.left();
    }

    public Chain append(Tile tile) {
        if (!canAppend(tile)) throw new RuntimeException("Tile not match");

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
