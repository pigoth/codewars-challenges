package org.example.challenge.domino;


import java.util.ArrayList;
import java.util.List;

public class All {
    List<List<Tile>> allChain = new ArrayList<>();

    public void listChains(List<Tile> chain, List<Tile> tiles) {
        for (int i = 0; i < tiles.size(); ++i) {
            final Tile dom = tiles.get(i);
            if (canAppend(dom, chain)) {
                allChain.add(mergeTileInChain(chain, dom));
                listChains(mergeTileInChain(chain, dom), removeCurrenFrom(tiles, i));
            }

            final Tile flipped = dom.flipped();
            if (canAppend(flipped, chain)) {
                allChain.add(mergeTileInChain(chain, flipped));
                listChains(mergeTileInChain(chain, flipped), removeCurrenFrom(tiles, i));
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
        return to.isEmpty() || to.get(to.size() - 1).b == dom.a;
    }

    public List<List<Tile>> allChain(Tile tile) {
        return allChain.stream()
                .filter(it -> it.contains(tile) || it.contains(tile.flipped()))
                .toList();
    }
}
