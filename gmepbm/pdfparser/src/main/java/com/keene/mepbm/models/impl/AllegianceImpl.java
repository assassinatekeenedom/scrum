package com.keene.mepbm.models.impl;

import com.keene.mepbm.models.Allegiance;

public class AllegianceImpl implements Allegiance {

    private int allegianceId;
    private String allegianceName;

    public AllegianceImpl() {
    }

    @Override
    public int getAllegianceId() {
        return allegianceId;
    }

    @Override
    public void setAllegianceId(int allegianceId) {
        this.allegianceId = allegianceId;
    }

    @Override
    public String getAllegianceName() {
        return allegianceName;
    }

    @Override
    public void setAllegianceName(String allegianceName) {
        this.allegianceName = allegianceName;
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        toString.append("\tALLEGIANCE INFO: ");
        toString.append(" (id=");
        toString.append(this.getAllegianceId());
        toString.append(")\n");
        toString.append("\t\tAllegiance Name: ");
        toString.append(this.getAllegianceName());
        toString.append("\n");
        return toString.toString();
    }
}
