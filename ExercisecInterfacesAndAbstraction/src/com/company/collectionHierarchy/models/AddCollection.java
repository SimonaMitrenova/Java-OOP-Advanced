package com.company.collectionHierarchy.models;

import com.company.collectionHierarchy.interfaces.Addable;

import java.util.LinkedList;
import java.util.List;

public class AddCollection implements Addable{
    private List<String> list;

    public AddCollection() {
        this.list = new LinkedList<>();
    }

    @Override
    public int add(String item) {
        int index = this.list.size();
        this.list.add(item);
        return index;
    }
}
