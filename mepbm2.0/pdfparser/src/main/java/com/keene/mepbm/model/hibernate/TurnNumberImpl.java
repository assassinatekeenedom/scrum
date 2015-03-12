package com.keene.mepbm.model.hibernate;

import com.keene.hibernate.dao.HibernateModel;
import com.keene.mepbm.model.TurnNumber;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
//@Table(name = "TurnNumber")
public class TurnNumberImpl implements Serializable, TurnNumber<GameImpl, SeasonImpl>, HibernateModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int turnNumberId;
    
    @Column
    private int number;

    @OneToOne()
    private SeasonImpl season;

    @OneToOne()
    private GameImpl game;
    
    public TurnNumberImpl() {
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public int getTurnNumberId() {
        return turnNumberId;
    }

    @Override
    public void setTurnNumberId(int turnNumberId) {
        this.turnNumberId = turnNumberId;
    }

    @Override
    public SeasonImpl getSeason() {
        return season;
    }

    @Override
    public void setSeason(SeasonImpl season) {
        this.season = season;
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
        toString.append("\tTURN NUMBER INFO: ");
        toString.append(" (id=");
        toString.append(this.getTurnNumberId());
        toString.append(")\n");
        toString.append("\t\tTurn Number: ");
        toString.append(this.getNumber());
        toString.append("\n");
        toString.append(this.getSeason());
        return toString.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TurnNumberImpl)) {
            return false;
        }
        TurnNumberImpl toon = (TurnNumberImpl) obj;
        if (this.getNumber()==toon.getNumber() && this.getGame().equals(toon.getGame())) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int number = this.getTurnNumberId();
        return PRIME * number;
    }
}
