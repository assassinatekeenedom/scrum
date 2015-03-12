package com.keene.mepbm.model;

public interface PopulationCenter<T extends TurnNumber, H extends Hex, N extends NationTurn>{

    public String getName();

    public void setName(String name);

    public boolean isCapital();

    public void setCapital(boolean capital);

    public String getDocks();

    public void setDocks(String docks);

    public String getFortification();

    public void setFortification(String fortification);

    public H getHex();

    public void setHex(H hex);

    public boolean isHidden();

    public void setHidden(boolean hidden);

    public int getLoyalty();

    public void setLoyalty(int loyalty);

    public int getPopulationCenterId();

    public void setPopulationCenterId(int populationCenterId);

    public boolean isSieged();

    public void setSieged(boolean sieged);

    public String getSize();

    public void setSize(String size);

    public T getTurnNumber();

    public void setTurnNumber(T turnNumber);

    public N getNationTurn();

    public void setNationTurn(N nationTurn);
    
}
