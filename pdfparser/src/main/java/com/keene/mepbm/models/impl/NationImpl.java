package com.keene.mepbm.models.impl;

import com.keene.mepbm.models.Game;
import com.keene.mepbm.models.Nation;
import com.keene.mepbm.models.Player;
import com.keene.mepbm.models.VictoryCondition;

public class NationImpl implements Nation<Game, Player, VictoryCondition> {

    private int nationId;
    private String name;
    private String email;
    private int number;
    private Player player;
    private Game game;

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
    public Player getPlayer() {
        return player;
    }

    @Override
    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public Game getGame() {
        return game;
    }

    @Override
    public void setGame(Game game) {
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
