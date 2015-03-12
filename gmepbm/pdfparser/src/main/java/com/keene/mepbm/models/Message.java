package com.keene.mepbm.models;

public interface Message<N extends NationTurn, T extends TurnNumber, G extends Game> {

    public String getMessage();

    public void setMessage(String message);

    public int getMessageId();

    public void setMessageId(int messageId);

    public N getNationTurn();

    public void setNationTurn(N nationTurn);

    public G getGame();

    public void setGame(G game);

    public T getTurnNumber();

    public void setTurnNumber(T turnNumber);

    public String getType();
    
    public void setType(String type);
}
