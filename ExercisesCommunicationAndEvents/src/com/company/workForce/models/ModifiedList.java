package com.company.workForce.models;


import com.company.workForce.contracts.JobCompletedListener;
import com.company.workForce.events.JobCompletedEvent;

import java.util.ArrayList;

public class ModifiedList<T> extends ArrayList<T> implements JobCompletedListener {

    @Override
    public void handleJobCompleted(JobCompletedEvent event) {
        this.remove(event.getSource());
    }
}
