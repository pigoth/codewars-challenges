package org.example.challenge.dominoes;

public class TailNOOOOO {
    private final int left;
    private final int right;

    public TailNOOOOO(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public boolean matchWith(Integer value) {
        return left == value || right == value;
    }

    public Integer right() {
        return right;
    }

    public Integer left() {
        return left;
    }

    public boolean matchRight(Integer value) {
        return right == value;
    }

    public boolean matchLeft(Integer value) {
        return left == value;
    }

    public TailNOOOOO reverse() {
        return new TailNOOOOO(right, left);
    }
}
