package com.keene.mepbm.models.impl;

import com.keene.mepbm.models.Upkeep;

public class UpkeepImpl implements Upkeep {

    private int upkeepId;
    private int armiesAndNavies;
    private int popCenters;
    private int characters;
    private int totalUpkeep;
    private int grossGold;
    private int netGold;
    private int reserves;
    private int taxRate;

    public UpkeepImpl() {
    }

    @Override
    public int getArmiesAndNavies() {
        return armiesAndNavies;
    }

    @Override
    public void setArmiesAndNavies(int armiesAndNavies) {
        this.armiesAndNavies = armiesAndNavies;
    }

    @Override
    public int getCharacters() {
        return characters;
    }

    @Override
    public void setCharacters(int characters) {
        this.characters = characters;
    }

    @Override
    public int getGrossGold() {
        return grossGold;
    }

    @Override
    public void setGrossGold(int grossGold) {
        this.grossGold = grossGold;
    }

    @Override
    public int getNetGold() {
        return netGold;
    }

    @Override
    public void setNetGold(int netGold) {
        this.netGold = netGold;
    }

    @Override
    public int getPopCenters() {
        return popCenters;
    }

    @Override
    public void setPopCenters(int popCenters) {
        this.popCenters = popCenters;
    }

    @Override
    public int getReserves() {
        return reserves;
    }

    @Override
    public void setReserves(int reserves) {
        this.reserves = reserves;
    }

    @Override
    public int getTotalUpkeep() {
        return totalUpkeep;
    }

    @Override
    public void setTotalUpkeep(int totalUpkeep) {
        this.totalUpkeep = totalUpkeep;
    }

    @Override
    public int getUpkeepId() {
        return upkeepId;
    }

    @Override
    public void setUpkeepId(int upkeepId) {
        this.upkeepId = upkeepId;
    }

    @Override
    public int getTaxRate() {
        return taxRate;
    }

    @Override
    public void setTaxRate(int taxRate) {
        this.taxRate = taxRate;
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        toString.append("\tUPKEEP INFO: ");
        toString.append(" (id=");
        toString.append(this.getUpkeepId());
        toString.append(")\n");
        toString.append("\t\tArmies & Navies: ");
        toString.append(this.getArmiesAndNavies());
        toString.append("\n");
        toString.append("\t\tPopulation Centers: ");
        toString.append(this.getPopCenters());
        toString.append("\n");
        toString.append("\t\tCharacters: ");
        toString.append(this.getCharacters());
        toString.append("\n");
        toString.append("\t\tTotal Upkeep: ");
        toString.append(this.getTotalUpkeep());
        toString.append("\n");
        toString.append("\t\tGross Gold: ");
        toString.append(this.getGrossGold());
        toString.append("\n");
        toString.append("\t\tNet Gold: ");
        toString.append(this.getNetGold());
        toString.append("\n");
        toString.append("\t\tReserves: ");
        toString.append(this.getReserves());
        toString.append("\n");
        return toString.toString();
    }
}
