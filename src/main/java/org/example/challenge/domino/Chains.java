package org.example.challenge.domino;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Chains {
    List<List<Tile>> allChain = new ArrayList<>();

    public Chains(List<Tile> tiles) {
        allChains(new ArrayList<>(), tiles);
    }

    private void allChains(List<Tile> chain, List<Tile> tiles) {
        for (int i = 0; i < tiles.size(); ++i) {
            final Tile dom = tiles.get(i);
            if (canAppend(dom, chain)) {
                List<Tile> currentChain = mergeTileInChain(chain, dom);
                if (currentChain.size() > 1) allChain.add(currentChain);
                allChains(currentChain, removeCurrenFrom(tiles, i));
            }

            final Tile flipped = dom.flip();
            if (canAppend(flipped, chain)) {
                List<Tile> currentChain = mergeTileInChain(chain, flipped);
                if (currentChain.size() > 1) allChain.add(currentChain);
                allChains(currentChain, removeCurrenFrom(tiles, i));
            }
        }
    }

    private List<Tile> removeCurrenFrom(List<Tile> tiles, int i) {
        return new ArrayList<>(tiles) {{
            remove(i);
        }};
    }

    private List<Tile> mergeTileInChain(List<Tile> chain, Tile dom) {
        return new ArrayList<>(chain) {{
            add(dom);
        }};
    }

    private boolean canAppend(Tile dom, List<Tile> to) {
        return to.isEmpty() || to.get(to.size() - 1).right() == dom.left();
    }

    public List<List<Tile>> allWith(Tile tile) {
        return allChain.stream()
                .filter(it -> it.contains(tile) || it.contains(tile.flip()))
                .toList();
    }

    public List<List<Tile>> all(Predicate<? super List<Tile>> condition) {
        return allChain.stream().filter(condition).toList();
    }
}
