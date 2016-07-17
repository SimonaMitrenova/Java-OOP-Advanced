package com.company.customList.models;

import java.util.List;

public class InsertionSorter<T extends Comparable<T>> implements Sorter<T> {

    @Override
    public void sort(List<T> collection) {
        for (int firstUnsortedIndex  = 0; firstUnsortedIndex  < collection.size(); firstUnsortedIndex ++) {
            int index = firstUnsortedIndex;
            while (index > 0 && collection.get(index - 1).compareTo(collection.get(index)) > 0){
                this.swap(collection, index, index - 1);
                index--;
            }
        }
    }

    private void swap(List<T> collection, int first, int second) {
        T temp = collection.get(first);
        collection.set(first, collection.get(second));
        collection.set(second, temp);
    }
}
