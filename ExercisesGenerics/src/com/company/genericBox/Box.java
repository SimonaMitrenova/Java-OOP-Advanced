package com.company.genericBox;

public class Box<T> {
    private T param;

    public Box(T param) {
        this.param = param;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.param.getClass().getName(), this.param);
    }
}
