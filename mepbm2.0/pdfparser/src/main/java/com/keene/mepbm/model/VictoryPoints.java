package com.keene.mepbm.model;

public interface VictoryPoints<N extends Nation, T extends NationTurn> {

    public int getArmy();

    public void setArmy(int army);

    public int getCharacter();

    public void setCharacter(int acharacter);

    public int getIndividual();

    public void setIndividual(int individual);

    public int getPopulationCenter();

    public void setPopulationCenter(int populationCenter);

    public int getVictoryPointsId();

    public void setVictoryPointsId(int victoryPointsId);

    public int getWealth();

    public void setWealth(int wealth);

    public N getNation();

    public void setNation(N nation);

    public T getNationTurn();

    public void setNationTurn(T nationTurn);
}
