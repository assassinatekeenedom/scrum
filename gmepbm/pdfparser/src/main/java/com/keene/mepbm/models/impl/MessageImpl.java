package com.keene.mepbm.models.impl;

import com.keene.mepbm.models.Game;
import com.keene.mepbm.models.Message;
import com.keene.mepbm.models.NationTurn;
import com.keene.mepbm.models.TurnNumber;

public class MessageImpl implements Message<NationTurn, TurnNumber, Game> {

    private int messageId;
    private String message;
    private String type;
    private NationTurn nationTurn;
    private TurnNumber turnNumber;
    private Game game;

    public MessageImpl() {
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int getMessageId() {
        return messageId;
    }

    @Override
    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    @Override
    public NationTurn getNationTurn() {
        return nationTurn;
    }

    @Override
    public void setNationTurn(NationTurn nationTurn) {
        this.nationTurn = nationTurn;
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
    public TurnNumber getTurnNumber() {
        return turnNumber;
    }

    @Override
    public void setTurnNumber(TurnNumber turnNumber) {
        this.turnNumber = turnNumber;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        toString.append("\tNATION MESSAGE INFO: ");
        toString.append(" (id=");
        toString.append(this.getMessageId());
        toString.append(")\n");
        toString.append("\t\tType:");
        toString.append(this.getType());
        toString.append("\n");
        toString.append("\t\tMessage:");
        toString.append(this.getMessage());
        toString.append("\n");
        return toString.toString();
    }
}
