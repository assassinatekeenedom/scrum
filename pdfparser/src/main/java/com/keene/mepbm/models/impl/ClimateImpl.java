package com.keene.mepbm.models.impl;

import com.keene.mepbm.models.Climate;

public class ClimateImpl implements Climate {

    private int climateId;
    private String name;

    public ClimateImpl() {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getClimateId() {
        return climateId;
    }

    @Override
    public void setClimateId(int climateId) {
        this.climateId = climateId;
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        toString.append("\tCLIMATE INFO: ");
        toString.append(" (id=");
        toString.append(this.getClimateId());
        toString.append(")\n");
        toString.append("\t\tName: ");
        toString.append(this.getName());
        toString.append("\n");
        return toString.toString();
    }
}
