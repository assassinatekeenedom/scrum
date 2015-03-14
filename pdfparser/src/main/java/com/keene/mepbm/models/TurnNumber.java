package com.keene.mepbm.models;

public interface TurnNumber<G extends Game, S extends Season> {

    public int getNumber();

    public void setNumber(int number);

    public int getTurnNumberId();

    public void setTurnNumberId(int turnNumberId);

    public S getSeason();

    public void setSeason(S season);

    public G getGame();

    public void setGame(G game);

}
