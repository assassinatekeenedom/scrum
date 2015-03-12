package com.keene.mepbm.model.hibernate;

import com.keene.hibernate.dao.HibernateModel;
import com.keene.mepbm.model.Allegiance;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@Table(name="Allegiance")
public class AllegianceImpl implements Serializable,Allegiance,HibernateModel<AllegianceImpl> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int allegianceId;

    @Column(unique=true)
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
    public String toString(){
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
