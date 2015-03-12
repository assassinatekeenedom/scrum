package com.keene.mepbm.models;

public interface Character<G extends Game, T extends TurnNumber, H extends Hex, N extends Nation, E extends NationTurn, M extends Army, P extends PopulationCenter, C extends Character> {

    public String getName();

    public void setName(String name);

    public int getCharacterId();

    public void setCharacterId(int characterId);

    public G getGame();

    public void setGame(G game);

    public int getAgentRank();

    public void setAgentRank(int agentRank);

    public int getChallengeRank();

    public void setChallengeRank(int challengeRank);

    public int getCommandRank();

    public void setCommandRank(int commandRank);

    public int getEmissaryRank();

    public void setEmissaryRank(int emissaryRank);

    public int getHealth();

    public void setHealth(int health);

    public H getHex();

    public void setHex(H hex);

    public int getMageRank();

    public void setMageRank(int mageRank);

    public String getOrderSummary();

    public void setOrderSummary(String orderSummary);

    public int getStealth();

    public void setStealth(int stealth);

    public T getTurnNumber();

    public void setTurnNumber(T turnNumber);

    public N getDoubleAgentOf();

    public void setDoubleAgentOf(N doubleAgentOf);

    public N getHostageOf();

    public void setHostageOf(N hostageOf);

    public int getTotalAgentRank();

    public void setTotalAgentRank(int toalAgentRank);

    public int getTotalCommandRank();

    public void setTotalCommandRank(int totalCommandRank);

    public int getTotalEmissaryRank();

    public void setTotalEmissaryRank(int totalEmissaryRank);

    public int getTotalMageRank();

    public void setTotalMageRank(int totalMageRank);

    public int getTotalStealth();

    public void setTotalStealth(int totalStealth);

    public E getNationTurn();

    public void setNationTurn(E nationTurn);

    public M getInArmy();

    public void setInArmy(M inArmy);

    public P getPopulationCenter();

    public void setPopulationCenter(P populationCenter);

    public C getHeldBy();

    public void setHeldBy(C heldBy);

    public boolean isKidnapped();

    public void setKidnapped(boolean kidnapped);
}
