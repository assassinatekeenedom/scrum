package com.keene.mepbm.models.impl;

import com.keene.mepbm.models.Army;
import com.keene.mepbm.models.Character;
import com.keene.mepbm.models.Game;
import com.keene.mepbm.models.Hex;
import com.keene.mepbm.models.Nation;
import com.keene.mepbm.models.NationTurn;
import com.keene.mepbm.models.PopulationCenter;
import com.keene.mepbm.models.TurnNumber;

public class CharacterImpl implements Character<Game, TurnNumber, Hex, Nation, NationTurn, Army, PopulationCenter, Character> {

    private int characterId;
    private String name;
    private int mageRank;
    private int emissaryRank;
    private int commandRank;
    private int agentRank;
    private int stealth;
    private int totalMageRank;
    private int totalEmissaryRank;
    private int totalCommandRank;
    private int totalAgentRank;
    private int totalStealth;
    private int health;
    private int challengeRank;
    private boolean kidnapped;
    private String orderSummary;
    private TurnNumber turnNumber;
    private Hex hex;
    private Nation hostageOf;
    private Character heldBy;
    private Nation doubleAgentOf;
    private Game game;
    private NationTurn nationTurn;
    private Army inArmy;
    private PopulationCenter populationCenter;

    public CharacterImpl() {
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
    public int getCharacterId() {
        return characterId;
    }

    @Override
    public void setCharacterId(int characterId) {
        this.characterId = characterId;
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
    public int getAgentRank() {
        return agentRank;
    }

    @Override
    public void setAgentRank(int agentRank) {
        this.agentRank = agentRank;
    }

    @Override
    public int getChallengeRank() {
        return challengeRank;
    }

    @Override
    public void setChallengeRank(int challengeRank) {
        this.challengeRank = challengeRank;
    }

    @Override
    public int getCommandRank() {
        return commandRank;
    }

    @Override
    public void setCommandRank(int commandRank) {
        this.commandRank = commandRank;
    }

    @Override
    public int getEmissaryRank() {
        return emissaryRank;
    }

    @Override
    public void setEmissaryRank(int emissaryRank) {
        this.emissaryRank = emissaryRank;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public Hex getHex() {
        return hex;
    }

    @Override
    public void setHex(Hex hex) {
        this.hex = hex;
    }

    @Override
    public int getMageRank() {
        return mageRank;
    }

    @Override
    public void setMageRank(int mageRank) {
        this.mageRank = mageRank;
    }

    @Override
    public String getOrderSummary() {
        return orderSummary;
    }

    @Override
    public void setOrderSummary(String orderSummary) {
        this.orderSummary = orderSummary;
    }

    @Override
    public int getStealth() {
        return stealth;
    }

    @Override
    public void setStealth(int stealth) {
        this.stealth = stealth;
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
    public Nation getDoubleAgentOf() {
        return doubleAgentOf;
    }

    @Override
    public void setDoubleAgentOf(Nation doubleAgentOf) {
        this.doubleAgentOf = doubleAgentOf;
    }

    @Override
    public Nation getHostageOf() {
        return hostageOf;
    }

    @Override
    public void setHostageOf(Nation hostageOf) {
        this.hostageOf = hostageOf;
    }

    @Override
    public int getTotalAgentRank() {
        return totalAgentRank;
    }

    @Override
    public void setTotalAgentRank(int totalAgentRank) {
        this.totalAgentRank = totalAgentRank;
    }

    @Override
    public int getTotalCommandRank() {
        return totalCommandRank;
    }

    @Override
    public void setTotalCommandRank(int totalCommandRank) {
        this.totalCommandRank = totalCommandRank;
    }

    @Override
    public int getTotalEmissaryRank() {
        return totalEmissaryRank;
    }

    @Override
    public void setTotalEmissaryRank(int totalEmissaryRank) {
        this.totalEmissaryRank = totalEmissaryRank;
    }

    @Override
    public int getTotalMageRank() {
        return totalMageRank;
    }

    @Override
    public void setTotalMageRank(int totalMageRank) {
        this.totalMageRank = totalMageRank;
    }

    @Override
    public int getTotalStealth() {
        return totalStealth;
    }

    @Override
    public void setTotalStealth(int totalStealth) {
        this.totalStealth = totalStealth;
    }

    @Override
    public NationTurn getNationTurn() {
        return nationTurn;
    }

    @Override
    public void setNationTurn(NationTurn nationTurn) {
        this.nationTurn = nationTurn;
    }

    @Override
    public Army getInArmy() {
        return inArmy;
    }

    @Override
    public void setInArmy(Army inArmy) {
        this.inArmy = inArmy;
    }

    @Override
    public PopulationCenter getPopulationCenter() {
        return populationCenter;
    }

    @Override
    public void setPopulationCenter(PopulationCenter populationCenter) {
        this.populationCenter = populationCenter;
    }

    @Override
    public Character getHeldBy() {
        return heldBy;
    }

    @Override
    public void setHeldBy(Character heldBy) {
        this.heldBy = heldBy;
    }

    @Override
    public boolean isKidnapped() {
        return kidnapped;
    }

    @Override
    public void setKidnapped(boolean kidnapped) {
        this.kidnapped = kidnapped;
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        toString.append("\tCHARACTER INFO: ");
        toString.append(" (id=");
        toString.append(this.getCharacterId());
        toString.append(")\n");
        toString.append("\t\tName: ");
        toString.append(this.getName());
        toString.append("\n");
        if (this.getHex() != null) {
            toString.append(this.getHex());
        }
        toString.append("\tCHARACTER STATS\n");
        toString.append("\t\tHealth - ");
        toString.append(this.getHealth());
        toString.append("\n");
        toString.append("\t\tChallenge Rank - ");
        toString.append(this.getChallengeRank());
        toString.append("\n");
        toString.append("\t\tAgent Rank - ");
        toString.append(this.getAgentRank());
        toString.append("\n");
        toString.append("\t\tTotal Agent Rank - ");
        toString.append(this.getTotalAgentRank());
        toString.append("\n");
        toString.append("\t\tCommand Rank - ");
        toString.append(this.getCommandRank());
        toString.append("\n");
        toString.append("\t\tTotal Command Rank - ");
        toString.append(this.getTotalCommandRank());
        toString.append("\n");
        toString.append("\t\tEmissary Rank - ");
        toString.append(this.getEmissaryRank());
        toString.append("\n");
        toString.append("\t\tTotal Emissary Rank - ");
        toString.append(this.getTotalEmissaryRank());
        toString.append("\n");
        toString.append("\t\tMage Rank - ");
        toString.append(this.getMageRank());
        toString.append("\n");
        toString.append("\t\tTotal Mage Rank - ");
        toString.append(this.getTotalMageRank());
        toString.append("\n");
        toString.append("\t\tStealth Rank - ");
        toString.append(this.getStealth());
        toString.append("\n");
        toString.append("\t\tTotal Stealth Rank - ");
        toString.append(this.getTotalStealth());
        toString.append("\n");
        toString.append("\t\tOrder Summary:\n");
        toString.append("\t\t");
        if (this.getOrderSummary() != null) {
            toString.append(this.getOrderSummary());
        }
        toString.append("\n");
        return toString.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CharacterImpl)) {
            return false;
        }
        CharacterImpl toon = (CharacterImpl) obj;
        if (this.getName().equals(toon.getName()) && this.getCharacterId() == toon.getCharacterId() && this.getTurnNumber().getTurnNumberId() == toon.getTurnNumber().getTurnNumberId()) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        return PRIME * this.getCharacterId() + this.getGame().getGameId() + this.getTurnNumber().getTurnNumberId();
    }
}
