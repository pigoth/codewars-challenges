package org.example.challenge.domino;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Chains extends ArrayList<Chain> {
    private final List<Chain> allChain;

    public Chains(List<Tile> tiles) {
        allChain = new ArrayList<>();
        allChains(Chain.empty(), tiles);
        this.addAll(allChain);
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

}
