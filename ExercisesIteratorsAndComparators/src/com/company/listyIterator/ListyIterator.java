package com.company.listyIterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ListyIterator<T> implements Iterator<T>{

    private List<T> data;
    private int index;

    public ListyIterator(List<T> data) {
        this.data = data;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return this.index < this.data.size() - 1;
    }

    @Override
    public T next() {
        if (hasNext()){
            return this.data.get(this.index++);
        }

        throw new NoSuchElementException();
    }

    public void print() {
        if (this.data.isEmpty()){
            throw new IllegalStateException("Invalid Operation!");
        }

        System.out.println(this.data.get(this.index));
    }

    public void printAll(){
        this.data.stream().forEach(d -> System.out.printf("%s ", d));
        System.out.println();
    }

    public boolean move() {
        if (hasNext()){
            this.index++;
            return true;
        }

        return false;
    }
}
