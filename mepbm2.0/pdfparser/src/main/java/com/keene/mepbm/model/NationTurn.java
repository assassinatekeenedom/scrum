package com.keene.mepbm.model;

public interface NationTurn<A extends Allegiance, I extends Nation, T extends TurnNumber, V extends VictoryPoints, K extends ResourceDetails, G extends Game, U extends Upkeep> {

    public A getAllegiance();

    public void setAllegiance(A allegiance);

    public int getNationTurnId();

    public void setNationTurnId(int nationTurnId);

    public T getTurnNumber();

    public void setTurnNumber(T turnNumber);

    public boolean isEliminated();

    public void setEliminated(boolean eliminated);

    public boolean isWinner();

    public void setWinner(boolean winner);

    public long getRunOnDate();

    public void setRunOnDate(long runOnDate);

    public boolean isSpecialService();

    public void setSpecialService(boolean specialService);

    public int getTotalVictoryPoints();

    public void setTotalVictoryPoints(int totalVictoryPoints);

    public V getVictoryPoints();

    public void setVictoryPoints(V victoryPoints);

    public I getNation();

    public void setNation(I nation);

    public G getGame();

    public void setGame(G game);

    public K getResourceDetails();

    public void setResourceDetails(K resourceDetails);

    public U getUpkeep();

    public void setUpkeep(U upkeep);

    public int getTransports();

    public void setTransports(int transports);

    public int getWarships();

    public void setWarships(int warships);
}
