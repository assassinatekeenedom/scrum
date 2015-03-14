package com.keene.mepbm.models.impl;

import com.keene.mepbm.models.Game;
import com.keene.mepbm.models.Nation;
import com.keene.mepbm.models.VictoryCondition;

public class VictoryConditionImpl implements VictoryCondition<Nation, Game> {

    private int victoryConditionId;
    private String description;
    private boolean achieved;
    private Nation nation;
    private Game game;

    public VictoryConditionImpl() {
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int getVictoryConditionId() {
        return victoryConditionId;
    }

    @Override
    public void setVictoryConditionId(int victoryConditionId) {
        this.victoryConditionId = victoryConditionId;
    }

    @Override
    public boolean isAchieved() {
        return achieved;
    }

    @Override
    public void setAchieved(boolean achieved) {
        this.achieved = achieved;
    }

    @Override
    public Nation getNation() {
        return nation;
    }

    @Override
    public void setNation(Nation nation) {
        this.nation = nation;
    }

    @Override
    public Game getGame() {
        return game;
    }

    @Override
    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        toString.append("\tVICTORY CONDITION INFO: ");
        toString.append(" (id=");
        toString.append(this.getVictoryConditionId());
        toString.append(")\n");
        toString.append("\t\tDescription: ");
        toString.append(this.getDescription());
        toString.append("\n");
        toString.append("\t\tAchived? ");
        toString.append(this.isAchieved());
        toString.append("\n");
        return toString.toString();
    }
}
