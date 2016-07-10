package com.company.collectionHierarchy.models;

import com.company.collectionHierarchy.interfaces.*;

import java.util.LinkedList;
import java.util.List;

public class AddRemoveCollection implements Addable, Removable{
    private LinkedList<String> list;

    public AddRemoveCollection() {
        this.list = new LinkedList<>();
    }

    @Override
    public int add(String item) {
        this.list.addFirst(item);
        return 0;
    }

    @Override
    public String remove() {
        return this.list.removeLast();
    }
}
