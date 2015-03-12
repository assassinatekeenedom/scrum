package com.keene.mepbm.model.hibernate;

import com.keene.hibernate.dao.HibernateModel;
import com.keene.mepbm.model.VictoryPoints;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
//@Table(name="VictoryPoints")
public class VictoryPointsImpl implements Serializable,VictoryPoints<NationImpl,NationTurnImpl>,HibernateModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int victoryPointsId;

    @Column
    private int army;

    @Column
    private int acharacter;

    @Column
    private int wealth;

    @Column
    private int populationCenter;
    
    @Column
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
    public NationImpl getNation() {
        return nation;
    }

    @Override
    public void setNation(NationImpl nation) {
        this.nation = nation;
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
