package com.keene.mepbm.models.impl;

import com.keene.mepbm.models.Allegiance;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AllegianceImpl implements Allegiance {

    @Id
    @GeneratedValue
    @Column(unique = true)
    private int id;
    @Column()
    private String allegianceName;

    public AllegianceImpl() {
    }

    @Override
    public int getAllegianceId() {
        return id;
    }

    @Override
    public void setAllegianceId(int allegianceId) {
        this.id = allegianceId;
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
