package org.example.challenge.dominoes;

public class Tail {
    private final int left;
    private final int right;

    public Tail(int left, int right) {
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

    public Tail reverse() {
        return new Tail(right, left);
    }
}
