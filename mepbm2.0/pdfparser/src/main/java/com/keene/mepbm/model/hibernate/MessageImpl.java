package com.keene.mepbm.model.hibernate;

import com.keene.hibernate.dao.HibernateModel;
import com.keene.mepbm.model.Message;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
//@Table(name="NationMessage")
public class MessageImpl implements Serializable, Message<NationTurnImpl, TurnNumberImpl, GameImpl>, HibernateModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int messageId;
    @Column(columnDefinition="TEXT")
    private String message;
    @Column
    private String type;
    @OneToOne
    private NationTurnImpl nationTurn;
    @OneToOne
    private TurnNumberImpl turnNumber;
    @OneToOne
    private GameImpl game;

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
    public NationTurnImpl getNationTurn() {
        return nationTurn;
    }

    @Override
    public void setNationTurn(NationTurnImpl nationTurn) {
        this.nationTurn = nationTurn;
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
    public TurnNumberImpl getTurnNumber() {
        return turnNumber;
    }

    @Override
    public void setTurnNumber(TurnNumberImpl turnNumber) {
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
