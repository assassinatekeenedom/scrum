package com.keene.mepbm.models;

public interface VictoryCondition<N extends Nation, G extends Game> {

    public String getDescription();

    public void setDescription(String description);

    public int getVictoryConditionId();

    public void setVictoryConditionId(int victoryConditionId);

    public boolean isAchieved();

    public void setAchieved(boolean achieved);

    public N getNation();

    public void setNation(N nation);

    public G getGame();

    public void setGame(G game);
}
