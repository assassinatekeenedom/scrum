package com.keene.mepbm.models.impl;

import com.keene.mepbm.models.Game;
import com.keene.mepbm.models.Nation;
import com.keene.mepbm.models.Player;
import com.keene.mepbm.models.VictoryCondition;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class NationImpl implements Nation<Game, Player, VictoryCondition> {

    @Id
    @GeneratedValue
    @Column(unique = true)
    private int id;
    @Column()
    private String name;
    @Column()
    private String email;
    @Column()
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
        return id;
    }

    @Override
    public void setNationId(int nationId) {
        this.id = nationId;
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
        this.player = (PlayerImpl) player;
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
