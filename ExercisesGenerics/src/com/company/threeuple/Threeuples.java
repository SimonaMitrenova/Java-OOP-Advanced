package com.company.threeuple;

public class Threeuples<F, S, T> {
    private F first;
    private S second;
    private T third;

    public Threeuples(F first, S second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }

    public T getThird() {
        return third;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s", this.first, this.second, this.third);
    }
}
