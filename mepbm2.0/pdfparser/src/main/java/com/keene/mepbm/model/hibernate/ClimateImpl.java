package com.keene.mepbm.model.hibernate;

import com.keene.hibernate.dao.HibernateModel;
import com.keene.mepbm.model.Climate;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@Table(name="Climate")
public class ClimateImpl implements Serializable,Climate,HibernateModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int climateId;

    @Column
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
