package com.company.workForce.contracts;

import com.company.workForce.events.JobCompletedEvent;

public interface JobCompletedListener {
    void handleJobCompleted(JobCompletedEvent event);
}
