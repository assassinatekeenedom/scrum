package com.keene.mepbm.model.hibernate;

import com.keene.hibernate.dao.HibernateModel;
import com.keene.mepbm.model.Hex;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
//@Table(name="Hex")
public class HexImpl implements Serializable, Hex<TerrainImpl, ClimateImpl>, HibernateModel {

    @Id
    // optionally could customize @Column(name = "meAllegianceId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int hexId;
    @Column
    private int hex;
    @OneToOne
    private TerrainImpl terrain;
    @OneToOne
    private ClimateImpl climate;

    public HexImpl() {
    }

    @Override
    public ClimateImpl getClimate() {
        return climate;
    }

    @Override
    public void setClimate(ClimateImpl climate) {
        this.climate = climate;
    }

    @Override
    public int getHex() {
        return hex;
    }

    @Override
    public void setHex(int hex) {
        this.hex = hex;
    }

    @Override
    public int getHexId() {
        return hexId;
    }

    @Override
    public void setHexId(int hexId) {
        this.hexId = hexId;
    }

    @Override
    public TerrainImpl getTerrain() {
        return terrain;
    }

    @Override
    public void setTerrain(TerrainImpl terrain) {
        this.terrain = terrain;
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        toString.append("\tHEX INFO: ");
        toString.append(" (id=");
        toString.append(this.getHexId());
        toString.append(")\n");
        toString.append("\t\tHex: ");
        toString.append(this.getHex());
        toString.append("\n");
        if (this.getTerrain() != null) {
            toString.append(this.getTerrain());
        }
        if (this.getClimate() != null) {
            toString.append(this.getClimate());
        }
        return toString.toString();
    }
}
