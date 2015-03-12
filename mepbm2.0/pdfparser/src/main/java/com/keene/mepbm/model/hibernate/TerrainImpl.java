package com.keene.mepbm.model.hibernate;

import com.keene.hibernate.dao.HibernateModel;
import com.keene.mepbm.model.Terrain;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@Table(name="Terrain")
public class TerrainImpl implements Serializable, Terrain,HibernateModel {

    @Id
    // optionally could customize @Column(name = "meAllegianceId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int terrainId;
    @Column
    private String name;

    public TerrainImpl() {
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
    public int getTerrainId() {
        return terrainId;
    }

    @Override
    public void setTerrainId(int terrainId) {
        this.terrainId = terrainId;
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        toString.append("\tTERRAIN INFO: ");
        toString.append(" (id=");
        toString.append(this.getTerrainId());
        toString.append(")\n");
        toString.append("\t\tName: ");
        toString.append(this.getName());
        toString.append("\n");
        return toString.toString();
    }
}
