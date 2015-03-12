package com.keene.mepbm.models.impl;

import com.keene.mepbm.models.Player;

public class PlayerImpl implements Player {

    private int playerId;
    private String name;
    private int accountNumber;
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
