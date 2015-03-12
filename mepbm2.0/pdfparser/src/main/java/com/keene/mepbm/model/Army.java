package com.keene.mepbm.model;

public interface Army<C extends Character, H extends Hex, N extends TurnNumber, I extends NationTurn, P extends PopulationCenter> {

    public C getArmyCommander();

    public void setArmyCommander(C armyCommander);

    public H getHex();

    public void setHex(H hex);

    public int getMorale();

    public void setMorale(int morale);

    public int getTransports();

    public void setTransports(int transports);

    public String getTravelMode();

    public void setTravelMode(String travelMode);

    public int getWarships();

    public void setWarships(int warships);

    public int getFood();

    public void setFood(int food);

    public int getWarMachines();

    public void setWarMachines(int warMachines);

    public String getArmyDetails();

    public void setArmyDetails(String armyDetails);

    public int getArmyId();

    public void setArmyId(int armyId);

    public N getTurnNumber();

    public void setTurnNumber(N turnNumber);

    public I getNationTurn();

    public void setNationTurn(I nationTurn);

    public P getPopulationCenter();

    public void setPopulationCenter(P populationCenter);
}
