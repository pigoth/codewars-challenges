package org.example.challenge.domino;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.IntPredicate;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;
import static java.util.stream.Stream.concat;

public class Chain {
    private final List<Tile> tiles;

    public static Chain empty() {
        return new Chain();
    }

    public static Chain of(Tile... tiles) {
        return new Chain(asList(tiles));
    }

    private Chain() {
        tiles = new ArrayList<>();
    }

    private Chain(List<Tile> tiles) {
        IntPredicate invalidMatch = index -> index != 0 && tiles.get(index - 1).right() != tiles.get(index).left();
        if(range(0, tiles.size()).anyMatch(invalidMatch)) throw new RuntimeException("Tile not match");

        this.tiles = tiles;
    }

    public boolean canAppend(Tile tile) {
        return tiles.isEmpty() || lastTile().right() == tile.left();
    }

    public Chain append(Tile tile) {
        if (!canAppend(tile)) throw new RuntimeException("Tile not match");

        return new Chain(concat(tiles.stream(), Stream.of(tile)).collect(toList()));
    }

    public boolean hasMinSize() {
        return tiles.size() > 1;
    }

    public boolean contains(Tile tile) {
        return tiles.contains(tile);
    }

    @Override
    public int hashCode() {
        return tiles != null ? tiles.hashCode() : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chain chain = (Chain) o;

        return Objects.equals(tiles, chain.tiles);
    }

    public Integer weight() {
        return tiles.stream()
                .mapToInt(Tile::right)
                .sum() - lastTile().right();
    }

    private Tile lastTile() {
        return tiles.get(tiles.size() - 1);
    }

}
