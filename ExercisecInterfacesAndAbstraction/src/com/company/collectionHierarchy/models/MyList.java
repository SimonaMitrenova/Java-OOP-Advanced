package com.company.collectionHierarchy.models;

import com.company.collectionHierarchy.interfaces.*;

import java.util.LinkedList;

public class MyList implements Addable, Removable, Usable{
    private LinkedList<String> list;

    public MyList() {
        this.list = new LinkedList<>();
    }

    @Override
    public int add(String item) {
        this.list.addFirst(item);
        return 0;
    }

    @Override
    public String remove() {
        return this.list.removeFirst();
    }

    @Override
    public int used() {
        return this.list.size();
    }
}
