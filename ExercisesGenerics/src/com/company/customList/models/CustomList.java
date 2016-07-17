package com.company.customList.models;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class CustomList<T extends Comparable<T>> implements Iterable<T>{
    private List<T> list;
    private Sorter<T> sorter;

    public CustomList(Sorter<T> sorter) {
        this.list = new LinkedList<>();
        this.sorter = sorter;
    }

    public void sort(){
        this.sorter.sort(this.list);
    }

    public int size(){
        return this.list.size();
    }

    public T get(int index){
        if (index < 0 || index >= this.list.size()){
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }

        return this.list.get(index);
    }

    public void add(T element){
        this.list.add(element);
    }

    public T remove(int index){
        if (index < 0 || index >= this.list.size()){
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
        return this.list.remove(index);
    }

    public boolean contains(T element){
        return this.list.contains(element);
    }

    public void swap(int firstIndex, int secondIndex){
        if (firstIndex < 0 || firstIndex >= this.list.size()){
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }

        if (secondIndex < 0 || secondIndex >= this.list.size()){
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }

        T temp = this.list.get(firstIndex);
        this.list.set(firstIndex, this.list.get(secondIndex));
        this.list.set(secondIndex, temp);
    }

    public int countGreaterThat(T element){
        int count = 0;
        for (int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i).compareTo(element) > 0){
                count++;
            }
        }
        return count;
    }

    public T getMax(){
        if (this.list.isEmpty()){
            throw new IllegalStateException("List is empty.");
        }

        T max = this.list.get(0);
        for (int i = 1; i < this.list.size(); i++) {
            if (max.compareTo(this.list.get(i)) < 0){
                max = this.list.get(i);
            }
        }
        return max;
    }

    public T getMin(){
        if (this.list.isEmpty()){
            throw new IllegalStateException("List is empty.");
        }

        T min = this.list.get(0);
        for (int i = 1; i < this.list.size(); i++) {
            if (min.compareTo(this.list.get(i)) > 0){
                min = this.list.get(i);
            }
        }
        return min;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        for (Iterator<T> iter = list.iterator(); iter.hasNext();) {
            T var = iter.next();
            action.accept(var);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < list.size();
            }

            @Override
            public T next() {
                return list.get(index++);
            }
        };
    }
}
