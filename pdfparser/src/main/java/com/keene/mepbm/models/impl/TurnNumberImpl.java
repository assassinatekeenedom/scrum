package com.keene.mepbm.models.impl;

import com.keene.mepbm.models.Game;
import com.keene.mepbm.models.Season;
import com.keene.mepbm.models.TurnNumber;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class TurnNumberImpl implements TurnNumber<Game, Season> {

    @Id
    @GeneratedValue
    @Column(unique = true)
    private int id;
    @Column()
    private int number;
    @OneToOne
    private SeasonImpl season;
    @OneToOne
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
        return id;
    }

    @Override
    public void setTurnNumberId(int turnNumberId) {
        this.id = turnNumberId;
    }

    @Override
    public Season getSeason() {
        return season;
    }

    @Override
    public void setSeason(Season season) {
        this.season = (SeasonImpl) season;
    }

    @Override
    public Game getGame() {
        return game;
    }

    @Override
    public void setGame(Game game) {
        this.game = (GameImpl) game;
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
        if (this.getNumber() == toon.getNumber() && this.getGame().equals(toon.getGame())) {
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
