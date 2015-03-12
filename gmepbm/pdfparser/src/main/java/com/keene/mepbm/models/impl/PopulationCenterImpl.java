package com.keene.mepbm.models.impl;

import com.keene.mepbm.models.Hex;
import com.keene.mepbm.models.NationTurn;
import com.keene.mepbm.models.PopulationCenter;
import com.keene.mepbm.models.TurnNumber;

public class PopulationCenterImpl implements PopulationCenter<TurnNumber, Hex, NationTurn> {

    private int populationCenterId;
    private String name;
    private int loyalty;
    private String pcSize;
    private String fortification;
    private boolean capital;
    private String docks;
    private boolean hidden;
    private boolean sieged;
    private TurnNumber turnNumber;
    private Hex hex;
    private NationTurn nationTurn;

    public PopulationCenterImpl() {
    }

    @Override
    public boolean isCapital() {
        return capital;
    }

    @Override
    public void setCapital(boolean capital) {
        this.capital = capital;
    }

    @Override
    public String getDocks() {
        return docks;
    }

    @Override
    public void setDocks(String docks) {
        this.docks = docks;
    }

    @Override
    public String getFortification() {
        return fortification;
    }

    @Override
    public void setFortification(String fortification) {
        this.fortification = fortification;
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
    public boolean isHidden() {
        return hidden;
    }

    @Override
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    @Override
    public int getLoyalty() {
        return loyalty;
    }

    @Override
    public void setLoyalty(int loyalty) {
        this.loyalty = loyalty;
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
    public int getPopulationCenterId() {
        return populationCenterId;
    }

    @Override
    public void setPopulationCenterId(int populationCenterId) {
        this.populationCenterId = populationCenterId;
    }

    @Override
    public boolean isSieged() {
        return sieged;
    }

    @Override
    public void setSieged(boolean sieged) {
        this.sieged = sieged;
    }

    @Override
    public String getSize() {
        return pcSize;
    }

    @Override
    public void setSize(String pcSize) {
        this.pcSize = pcSize;
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
    public NationTurn getNationTurn() {
        return nationTurn;
    }

    @Override
    public void setNationTurn(NationTurn nationTurn) {
        this.nationTurn = nationTurn;
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        toString.append("\tPOPULATION CENTER INFO: ");
        toString.append(" (id=");
        toString.append(this.getPopulationCenterId());
        toString.append(")");
        toString.append("\n");
        toString.append("\t\tName: ");
        toString.append(this.getName());
        toString.append("\n");
        toString.append("\t\tLoyalty: ");
        toString.append(this.getLoyalty());
        toString.append("\n");
        toString.append("\t\tSize: ");
        toString.append(this.getSize());
        toString.append("\n");
        toString.append("\t\tFortifications: ");
        toString.append(this.getFortification());
        toString.append("\n");
        toString.append("\t\tCapital? ");
        toString.append(this.isCapital());
        toString.append("\n");
        toString.append("\t\tDocks: ");
        toString.append(this.getDocks());
        toString.append("\n");
        toString.append("\t\tHidden? ");
        toString.append(this.isHidden());
        toString.append("\n");
        toString.append("\t\tSieged? ");
        toString.append(this.isSieged());
        toString.append("\n");
        toString.append(this.getHex());
        return toString.toString();
    }
}
