package com.keene.mepbm.model.hibernate;

import com.keene.hibernate.dao.HibernateModel;
import com.keene.mepbm.model.Army;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
//@Table(name="Army")
public class ArmyImpl implements Serializable, Army<CharacterImpl, HexImpl, TurnNumberImpl, NationTurnImpl, PopulationCenterImpl>, HibernateModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int armyId;
    @Column
    private int morale;
    @Column
    private int food;
    @Column
    private int warships;
    @Column
    private int transports;
    @Column
    private int warMachines;
    @Column
    private String travelMode;
    @Column(columnDefinition="TEXT")
    private String armyDetails;
    @OneToOne
    private HexImpl hex;
    @OneToOne
    private TurnNumberImpl turnNumber;
    @OneToOne
    private CharacterImpl armyCommander;
    @OneToOne
    private NationTurnImpl nationTurn;
    @OneToOne
    private PopulationCenterImpl populationCenter;

    public ArmyImpl() {
    }

    @Override
    public CharacterImpl getArmyCommander() {
        return this.armyCommander;
    }

    @Override
    public void setArmyCommander(CharacterImpl armyCommander) {
        this.armyCommander = armyCommander;
    }

    @Override
    public HexImpl getHex() {
        return hex;
    }

    @Override
    public void setHex(HexImpl hex) {
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
    public TurnNumberImpl getTurnNumber() {
        return turnNumber;
    }

    @Override
    public void setTurnNumber(TurnNumberImpl turnNumber) {
        this.turnNumber = turnNumber;
    }

    @Override
    public NationTurnImpl getNationTurn() {
        return nationTurn;
    }

    @Override
    public void setNationTurn(NationTurnImpl nationTurn) {
        this.nationTurn = nationTurn;
    }

    @Override
    public PopulationCenterImpl getPopulationCenter() {
        return populationCenter;
    }

    @Override
    public void setPopulationCenter(PopulationCenterImpl populationCenter) {
        this.populationCenter = populationCenter;
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
