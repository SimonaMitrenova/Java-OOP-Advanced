package com.company.militaryElite.models;

import com.company.militaryElite.interfaces.IMission;

public class Mission implements IMission{
    private String codeName;
    private String missionState;

    public Mission(String codeName, String missionState) {
        this.codeName = codeName;
        this.setMissionState(missionState);
    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    @Override
    public String getMissionState() {
        return this.missionState;
    }

    private void setMissionState(String missionState) {
        if (!missionState.equalsIgnoreCase("inProgress") && !missionState.equalsIgnoreCase("finished")){
            throw new IllegalArgumentException();
        }
        this.missionState = missionState;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", this.getCodeName(), this.getMissionState());
    }
}
