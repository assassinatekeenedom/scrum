package com.keene.mepbm.models.impl;

import com.keene.mepbm.models.Army;
import com.keene.mepbm.models.Character;
import com.keene.mepbm.models.Hex;
import com.keene.mepbm.models.Nation;
import com.keene.mepbm.models.TurnNumber;

public class ArmyImpl implements Army<Character, Hex, TurnNumber, Nation>{

    private int armyId;
    private int morale;
    private int food;
    private int warships;
    private int transports;
    private int warMachines;
    private String travelMode;
    private String armyDetails;
    private Hex hex;
    private TurnNumber turnNumber;
    private Character armyCommander;
    private Nation nation;

    public ArmyImpl() {
    }

    @Override
    public Character getArmyCommander() {
        return this.armyCommander;
    }

    @Override
    public void setArmyCommander(Character armyCommander) {
        this.armyCommander = armyCommander;
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
    public int getMorale() {
        return morale;
    }

    @Override
    public void setMorale(int morale) {
        this.morale = morale;
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
    public String getTravelMode() {
        return travelMode;
    }

    @Override
    public void setTravelMode(String travelMode) {
        this.travelMode = travelMode;
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
    public int getFood() {
        return food;
    }

    @Override
    public void setFood(int food) {
        this.food = food;
    }

    @Override
    public int getWarMachines() {
        return warMachines;
    }

    @Override
    public void setWarMachines(int warMachines) {
        this.warMachines = warMachines;
    }

    @Override
    public String getArmyDetails() {
        return armyDetails;
    }

    @Override
    public void setArmyDetails(String armyDetails) {
        this.armyDetails = armyDetails;
    }

    @Override
    public int getArmyId() {
        return armyId;
    }

    @Override
    public void setArmyId(int armyId) {
        this.armyId = armyId;
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
    public Nation getNation() {
        return nation;
    }

    @Override
    public void setNation(Nation nation) {
        this.nation = nation;
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        toString.append("\tARMY INFO: ");
        toString.append(" (id=");
        toString.append(this.getArmyId());
        toString.append(")\n");
        toString.append("\t\tArmy Commander: ");
        toString.append("\n");
        toString.append(this.getArmyCommander());
        toString.append("\t\tMorale: ");
        toString.append(this.getMorale());
        toString.append("\n");
        toString.append("\t\tFood: ");
        toString.append(this.getFood());
        toString.append("\n");
        toString.append("\t\tWar Machines: ");
        toString.append(this.getWarMachines());
        toString.append("\n");
        toString.append("\t\tTransports: ");
        toString.append(this.getTransports());
        toString.append("\n");
        toString.append("\t\tTravel Mode: ");
        toString.append(this.getTravelMode());
        toString.append("\n");
        toString.append("\t\tWarships: ");
        toString.append(this.getWarships());
        toString.append("\n");
        if (this.getHex() == null) {
        } else {
            toString.append(this.getHex());
        }
        toString.append("\t\tMisc Details: ");
        toString.append(this.getArmyDetails());
        toString.append("\n");
        return toString.toString();
    }
}
