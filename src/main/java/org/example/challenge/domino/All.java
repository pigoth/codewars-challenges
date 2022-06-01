package org.example.challenge.domino;


import java.util.ArrayList;
import java.util.List;

public class All {
    List<List<Tile>> allChain = new ArrayList<>();

    public void listChains(List<Tile> chain, List<Tile> list) {

        for (int i = 0; i < list.size(); ++i) {
            Tile dom = list.get(i);
            if (canAppend(dom, chain)) {
                chain.add(dom);
                allChain.add(List.copyOf(chain));
                Tile saved = list.remove(i);
                listChains(chain, list);
                list.add(i, saved);
                chain.remove(chain.size() - 1);
            }
            dom = dom.flipped();
            if (canAppend(dom, chain)) {
                chain.add(dom);
                Tile saved = list.remove(i);
                listChains(chain, list);
                list.add(i, saved);
                chain.remove(chain.size() - 1);
            }
        }
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
