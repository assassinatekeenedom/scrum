package com.keene.mepbm.model.hibernate;

import com.keene.hibernate.dao.HibernateModel;
import com.keene.mepbm.model.Game;
import com.keene.mepbm.model.Player;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@Table(name="Game")
public class GameImpl implements Serializable, Game, HibernateModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int gameId;

    @Column
    private int number;

    @Column(name = "gameModule")
    private String module;

    @Column
    private String description;    

    public GameImpl() {
    }

    @Override
    public int getGameId() {
        return gameId;
    }

    @Override
    public void setGameId(int gameId) {
        this.gameId = gameId;
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
    public String getModule() {
        return module;
    }

    @Override
    public void setModule(String module) {
        this.module = module;
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
    public String toString() {
        StringBuilder toString = new StringBuilder();
        toString.append("GAME INFO: ");
        toString.append(" (id=");
        toString.append(this.getGameId());
        toString.append(")\n");
        toString.append("\tModule: ");
        toString.append(this.getModule());
        toString.append("\n");
        toString.append("\tNumber: ");
        toString.append(this.getNumber());
        toString.append("\n");
        toString.append("\tDescription: ");
        toString.append(this.getDescription());
        toString.append("\n");       
        return toString.toString();
    }
}
