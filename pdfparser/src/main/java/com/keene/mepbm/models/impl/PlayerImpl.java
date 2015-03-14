package com.keene.mepbm.models.impl;

import com.keene.mepbm.models.Player;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PlayerImpl implements Player {

    @Id
    @GeneratedValue
    @Column(unique = true)
    private int playerId;
    @Column()
    private String name;
    @Column()
    private int accountNumber;
    @Column()
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
