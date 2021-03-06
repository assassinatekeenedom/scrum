package com.keene.mepbm.models.impl;

import com.keene.mepbm.models.Season;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SeasonImpl implements Season {

    @Id
    @GeneratedValue
    @Column(unique = true)
    private int seasonId;
    @Column()
    private String name;

    public SeasonImpl() {
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
    public int getSeasonId() {
        return seasonId;
    }

    @Override
    public void setSeasonId(int seasonId) {
        this.seasonId = seasonId;
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        toString.append("\tSEASON INFO:");
        toString.append(" (id=");
        toString.append(this.getSeasonId());
        toString.append(")\n");
        toString.append("\tSeason Name: ");
        toString.append(this.getName());
        toString.append("\n");
        return toString.toString();
    }
}
