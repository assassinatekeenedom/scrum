package com.keene.mepbm.model.hibernate;

import com.keene.hibernate.dao.HibernateModel;
import com.keene.mepbm.model.Nation;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
//@Table(name="Nation")
public class NationImpl implements Serializable, Nation<GameImpl, PlayerImpl, VictoryConditionImpl>, HibernateModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int nationId;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private int number;

    @OneToOne
    private PlayerImpl player;

    @OneToOne
    private GameImpl game;

    public NationImpl() {
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
    public int getNationId() {
        return nationId;
    }

    @Override
    public void setNationId(int nationId) {
        this.nationId = nationId;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public PlayerImpl getPlayer() {
        return player;
    }

    @Override
    public void setPlayer(PlayerImpl player) {
        this.player = player;
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
    public int getNumber() {
        return number;
    }

    @Override
    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        toString.append("\tNATION INFO: ");
        toString.append(" (id=");
        toString.append(this.getNationId());
        toString.append(")\n");
        toString.append("\t\tName: ");
        toString.append(this.getName());
        toString.append("\n\t\tNation Number: ");
        toString.append(this.getNumber());
        toString.append("\n");
        toString.append(this.getPlayer());
        toString.append("\t\tEmail For This Game: ");
        toString.append(this.getEmail());
        toString.append("\n");
        toString.append(this.getPlayer());
        return toString.toString();
    }

}
