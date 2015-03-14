package com.keene.mepbm.models.impl;

import com.keene.mepbm.models.Climate;
import com.keene.mepbm.models.Hex;
import com.keene.mepbm.models.Terrain;

public class HexImpl implements Hex<Terrain, Climate> {

    private int hexId;
    private int hex;
    private Terrain terrain;
    private Climate climate;

    public HexImpl() {
    }

    @Override
    public Climate getClimate() {
        return climate;
    }

    @Override
    public void setClimate(Climate climate) {
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
    public Terrain getTerrain() {
        return terrain;
    }

    @Override
    public void setTerrain(Terrain terrain) {
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
