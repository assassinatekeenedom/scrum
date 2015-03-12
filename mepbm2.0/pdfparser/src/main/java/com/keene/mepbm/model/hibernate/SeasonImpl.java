package com.keene.mepbm.model.hibernate;

import com.keene.hibernate.dao.HibernateModel;
import com.keene.mepbm.model.Season;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@Table(name="Season")
public class SeasonImpl implements Serializable,Season,HibernateModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int seasonId;

    @Column(unique=true)
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
    public String toString(){
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
