package com.keene.mepbm.models.impl;

import com.keene.mepbm.models.Allegiance;
import com.keene.mepbm.models.Game;
import com.keene.mepbm.models.Nation;
import com.keene.mepbm.models.NationTurn;
import com.keene.mepbm.models.ResourceDetails;
import com.keene.mepbm.models.TurnNumber;
import com.keene.mepbm.models.Upkeep;
import com.keene.mepbm.models.VictoryPoints;

public class NationTurnImpl implements NationTurn<Allegiance, Nation, TurnNumber, VictoryPoints, ResourceDetails, Game, Upkeep> {

    private int nationTurnId;
    private boolean eliminated;
    private boolean winner;
    private int totalVictoryPoints;
    private long runOnDate;
    private boolean specialService;
    private int warships;
    private int transports;
    private Game game;
    private Nation nation;
    private ResourceDetails resourceDetails;
    private Upkeep upkeep;
    private TurnNumber turnNumber;
    private Allegiance allegiance;
    private VictoryPoints victoryPoints;

    public NationTurnImpl() {
    }

    @Override
    public Allegiance getAllegiance() {
        return allegiance;
    }

    @Override
    public void setAllegiance(Allegiance allegiance) {
        this.allegiance = allegiance;
    }

    @Override
    public int getNationTurnId() {
        return nationTurnId;
    }

    @Override
    public void setNationTurnId(int nationTurnId) {
        this.nationTurnId = nationTurnId;
    }

    @Override
    public TurnNumber getTurnNumber() {
        return turnNumber;
    }

    @Override
    public void setTurnNumber(TurnNumber turnNumber) {
        this.turnNumber = turnNumber;
    }

    @Override
    public boolean isEliminated() {
        return eliminated;
    }

    @Override
    public void setEliminated(boolean eliminated) {
        this.eliminated = eliminated;
    }

    @Override
    public boolean isWinner() {
        return winner;
    }

    @Override
    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    @Override
    public long getRunOnDate() {
        return runOnDate;
    }

    @Override
    public void setRunOnDate(long runOnDate) {
        this.runOnDate = runOnDate;
    }

    @Override
    public boolean isSpecialService() {
        return specialService;
    }

    @Override
    public void setSpecialService(boolean specialService) {
        this.specialService = specialService;
    }

    @Override
    public int getTotalVictoryPoints() {
        return totalVictoryPoints;
    }

    @Override
    public void setTotalVictoryPoints(int totalVictoryPoints) {
        this.totalVictoryPoints = totalVictoryPoints;
    }

    @Override
    public VictoryPoints getVictoryPoints() {
        return victoryPoints;
    }

    @Override
    public void setVictoryPoints(VictoryPoints victoryPoints) {
        this.victoryPoints = victoryPoints;
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
    public ResourceDetails getResourceDetails() {
        return resourceDetails;
    }

    @Override
    public void setResourceDetails(ResourceDetails resourceDetails) {
        this.resourceDetails = resourceDetails;
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
    public Upkeep getUpkeep() {
        return upkeep;
    }

    @Override
    public void setUpkeep(Upkeep upkeep) {
        this.upkeep = upkeep;
    }

    @Override
    public int getTransports() {
        return transports;
    }

    @Override
    public void setTransports(int transports) {
        this.transports = transports;
    }

    @Override
    public int getWarships() {
        return warships;
    }

    @Override
    public void setWarships(int warships) {
        this.warships = warships;
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        toString.append("\tNATION TURN INFO:");
        toString.append(" (id=");
        toString.append(this.getNationTurnId());
        toString.append(")\n");
        toString.append("\t\tEliminated? ");
        toString.append(this.isEliminated());
        toString.append("\n");
        toString.append("\t\tWinner? ");
        toString.append(this.isWinner());
        toString.append("\n");
        toString.append("\t\tTotal Victory Points: ");
        toString.append(this.getTotalVictoryPoints());
        toString.append("\n");
        toString.append("\t\tRun On Date: ");
        toString.append(this.getRunOnDate());
        toString.append("\n");
        toString.append("\t\tSpecial Service? ");
        toString.append(this.isSpecialService());
        toString.append("\n");
        toString.append(this.getVictoryPoints());
        toString.append(this.getUpkeep());
        toString.append(this.getResourceDetails());
        toString.append(this.getAllegiance());
        toString.append(this.getNation());
        return toString.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NationTurnImpl)) {
            return false;
        }
        NationTurnImpl toon = (NationTurnImpl) obj;
        if (this.getNationTurnId() == toon.getNationTurnId()) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        return PRIME * this.getNationTurnId();
    }
}
