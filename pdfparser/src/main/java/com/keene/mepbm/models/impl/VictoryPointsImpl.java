package com.keene.mepbm.models.impl;

import com.keene.mepbm.models.Nation;
import com.keene.mepbm.models.NationTurn;
import com.keene.mepbm.models.VictoryPoints;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class VictoryPointsImpl implements VictoryPoints<Nation, NationTurn> {

    @Id
    @GeneratedValue
    @Column(unique = true)
    private int victoryPointsId;
    @Column()
    private int army;
    @Column()
    private int acharacter;
    @Column()
    private int wealth;
    @Column()
    private int populationCenter;
    @Column()
    private int individual;
    @OneToOne
    private NationImpl nation;
    @OneToOne
    private NationTurnImpl nationTurn;

    public VictoryPointsImpl() {
    }

    @Override
    public int getArmy() {
        return army;
    }

    @Override
    public void setArmy(int army) {
        this.army = army;
    }

    @Override
    public int getCharacter() {
        return acharacter;
    }

    @Override
    public void setCharacter(int acharacter) {
        this.acharacter = acharacter;
    }

    @Override
    public int getIndividual() {
        return individual;
    }

    @Override
    public void setIndividual(int individual) {
        this.individual = individual;
    }

    @Override
    public int getPopulationCenter() {
        return populationCenter;
    }

    @Override
    public void setPopulationCenter(int populationCenter) {
        this.populationCenter = populationCenter;
    }

    @Override
    public int getVictoryPointsId() {
        return victoryPointsId;
    }

    @Override
    public void setVictoryPointsId(int victoryPointsId) {
        this.victoryPointsId = victoryPointsId;
    }

    @Override
    public int getWealth() {
        return wealth;
    }

    @Override
    public void setWealth(int wealth) {
        this.wealth = wealth;
    }

    @Override
    public Nation getNation() {
        return nation;
    }

    @Override
    public void setNation(Nation nation) {
        this.nation = (NationImpl) nation;
    }

    @Override
    public NationTurn getNationTurn() {
        return nationTurn;
    }

    @Override
    public void setNationTurn(NationTurn nationTurn) {
        this.nationTurn = (NationTurnImpl) nationTurn;
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        toString.append("\tVICTORY POINT INFO: ");
        toString.append(" (id=");
        toString.append(this.getVictoryPointsId());
        toString.append(")\n");
        toString.append("\t\tIndividual: ");
        toString.append(this.getIndividual());
        toString.append("\n");
        toString.append("\t\tArmy: ");
        toString.append(this.getArmy());
        toString.append("\n");
        toString.append("\t\tCharacter: ");
        toString.append(this.getCharacter());
        toString.append("\n");
        toString.append("\t\tWealth: ");
        toString.append(this.getWealth());
        toString.append("\n");
        toString.append("\t\tPopulation Center: ");
        toString.append(this.getPopulationCenter());
        toString.append("\n");
        return toString.toString();
    }
}
