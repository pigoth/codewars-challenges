package org.example.challenge.domino;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Chains {
    List<Chain> allChain = new ArrayList<>();

    public Chains(List<Tile> tiles) {
        allChains(Chain.empty(), tiles);
    }

    private void allChains(Chain chain, List<Tile> tiles) {
        for (int i = 0; i < tiles.size(); ++i) {
            final Tile dom = tiles.get(i);
            if (chain.canAppend(dom)) {
                Chain currentChain = chain.append(dom);
                if (currentChain.hasMinSize()) allChain.add(currentChain);
                allChains(currentChain, removeCurrenFrom(tiles, i));
            }

            final Tile flipped = dom.flip();
            if (chain.canAppend(flipped)) {
                Chain currentChain = chain.append(flipped);
                if (currentChain.hasMinSize()) allChain.add(currentChain);
                allChains(currentChain, removeCurrenFrom(tiles, i));
            }
        }
    }

    private List<Tile> removeCurrenFrom(List<Tile> tiles, int i) {
        return new ArrayList<>(tiles) {{
            remove(i);
        }};
    }

    public List<Chain> all(Predicate<? super Chain> condition) {
        return allChain.stream().filter(condition).toList();
    }

}
