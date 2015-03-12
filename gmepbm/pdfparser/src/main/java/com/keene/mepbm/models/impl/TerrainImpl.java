package com.keene.mepbm.models.impl;

import com.keene.mepbm.models.Terrain;

public class TerrainImpl implements Terrain{

    private int terrainId;
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
