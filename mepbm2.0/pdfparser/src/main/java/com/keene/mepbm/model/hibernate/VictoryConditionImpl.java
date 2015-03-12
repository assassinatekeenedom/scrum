package com.keene.mepbm.model.hibernate;

import com.keene.hibernate.dao.HibernateModel;
import com.keene.mepbm.model.VictoryCondition;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
//@Table(name="VictoryCondition")
public class VictoryConditionImpl implements Serializable, VictoryCondition<NationImpl, GameImpl>, HibernateModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int victoryConditionId;
    @Column
    private String description;
    @Column
    private boolean achieved;
    @OneToOne
    private NationImpl nation;
    @OneToOne
    private GameImpl game;

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
    public NationImpl getNation() {
        return nation;
    }

    @Override
    public void setNation(NationImpl nation) {
        this.nation = nation;
    }

    @Override
    public GameImpl getGame() {
        return game;
    }

    @Override
    public void setGame(GameImpl game) {
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
