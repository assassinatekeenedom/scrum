package com.keene.mepbm.model.hibernate;

import com.keene.hibernate.dao.HibernateModel;
import com.keene.mepbm.model.SNA;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
//@Table(name="SNA")
public class SNAImpl implements Serializable,SNA<NationImpl>,HibernateModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int snaId;

    @Column(unique=true)
    private int number;

    @Column(unique=true)
    private String description;

    @OneToOne
    private NationImpl nation;

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
    public NationImpl getNation() {
        return nation;
    }

    @Override
    public void setNation(NationImpl nation) {
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
