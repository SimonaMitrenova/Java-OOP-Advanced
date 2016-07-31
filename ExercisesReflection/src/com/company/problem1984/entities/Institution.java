package com.company.problem1984.entities;

import com.company.problem1984.entities.contracts.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Institution implements Observer{

    private String id;
    private String name;
    List<String> subjectsMonitored;
    List<String> changeLog;

    public Institution(String id, String name, String... subjects) {
        this.id = id;
        this.name = name;
        this.subjectsMonitored = new ArrayList<>();
        Collections.addAll(subjectsMonitored, subjects);
        this.changeLog = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public List<String> getChangeLog() {
        return this.changeLog;
    }

    @Override
    public void update(Event event) {
        Observable observable = event.getSource();
        String sourceClass = observable.getClass().getSimpleName();
        String id = observable.getId();
        Field changedField = event.getChangedField();

        String fieldName = changedField.getName();
        String fieldType = changedField.getType().getSimpleName();

        String oldValue = event.getOldValue().toString();
        String newValue = event.getNewValue().toString();

        if (subjectsMonitored.contains(fieldName)){
            String result =
                    String.format("--%s(ID:%s) changed %s(%s) from %s to %s",
                            sourceClass,
                            id,
                            fieldName,
                            fieldType,
                            oldValue,
                            newValue);

            this.changeLog.add(result);
        }
    }
}
