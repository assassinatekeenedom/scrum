package com.keene.mepbm.models.impl;

import com.keene.mepbm.models.Nation;
import com.keene.mepbm.models.SNA;

public class SNAImpl implements SNA<Nation> {

    private int snaId;
    private int number;
    private String description;
    private Nation nation;

    public SNAImpl() {
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public int getSnaId() {
        return snaId;
    }

    @Override
    public void setSnaId(int snaId) {
        this.snaId = snaId;
    }

    @Override
    public Nation getNation() {
        return nation;
    }

    @Override
    public void setNation(Nation nation) {
        this.nation = nation;
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        toString.append("\tSNA INFO: ");
        toString.append(" (id=");
        toString.append(this.getSnaId());
        toString.append(")\n");
        toString.append("\t\tNumber: ");
        toString.append(this.getNumber());
        toString.append("\n");
        toString.append("\t\tDescription: ");
        toString.append(this.getDescription());
        toString.append("\n");
        return toString.toString();
    }
}
