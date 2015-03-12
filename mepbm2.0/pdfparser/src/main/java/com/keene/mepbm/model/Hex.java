package com.keene.mepbm.model;

public interface Hex<T extends Terrain, C extends Climate> {

    public C getClimate();

    public void setClimate(C climate);

    public int getHex();

    public void setHex(int hex);

    public T getTerrain();

    public void setTerrain(T terrain);

    public int getHexId();

    public void setHexId(int hexId);
    
}
