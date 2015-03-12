package com.keene.mepbm.model.hibernate;

import com.keene.hibernate.dao.HibernateModel;
import com.keene.mepbm.model.Player;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@Table(name="Player")
public class PlayerImpl implements Serializable, Player, HibernateModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int playerId;
    @Column
    private String name;
    @Column
    private int accountNumber;
    @Column
    private String email;

    public PlayerImpl() {
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
    public int getPlayerId() {
        return playerId;
    }

    @Override
    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    @Override
    public int getAccountNumber() {
        return accountNumber;
    }

    @Override
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
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
    public String toString() {
        StringBuilder toString = new StringBuilder();
        toString.append("\tPLAYER INFO:");
        toString.append(" (id=");
        toString.append(this.getPlayerId());
        toString.append(")\n");
        toString.append("\t\tName: ");
        toString.append(this.getName());
        toString.append("\n");
        toString.append("\t\tAccount Number: ");
        toString.append(this.getAccountNumber());
        toString.append("\n");
        toString.append("\t\tPermanent Email: ");
        toString.append(this.getEmail());
        toString.append("\n");
        return toString.toString();
    }
}
