package com.keene.mepbm.models;

public interface Nation<G extends Game, P extends Player, V extends VictoryCondition> {

    public String getName();

    public void setName(String name);

    public int getNationId();

    public void setNationId(int nationId);

    public String getEmail();

    public void setEmail(String email);

    public P getPlayer();

    public void setPlayer(P player);

    public G getGame();

    public void setGame(G game);

    public int getNumber();

    public void setNumber(int number);

}
