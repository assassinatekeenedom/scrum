package com.keene.mepbm.models.impl;

import com.keene.mepbm.models.Nation;
import com.keene.mepbm.models.NationRelation;
import com.keene.mepbm.models.NationTurn;
import com.keene.mepbm.models.Relation;
import com.keene.mepbm.models.TurnNumber;

public class NationRelationImpl implements NationRelation<TurnNumber, Relation, Nation, NationTurn> {

    private int nationRelationId;
    private TurnNumber turnNumber;
    private Nation source;
    private Nation destination;
    private Relation relation;
    private NationTurn nationTurn;

    public NationRelationImpl() {
    }

    @Override
    public Relation getRelation() {
        return relation;
    }

    @Override
    public void setRelation(Relation relation) {
        this.relation = relation;
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
    public int getNationRelationId() {
        return nationRelationId;
    }

    @Override
    public void setNationRelationId(int nationRelationId) {
        this.nationRelationId = nationRelationId;
    }

    @Override
    public Nation getDestination() {
        return destination;
    }

    @Override
    public void setDestination(Nation destination) {
        this.destination = destination;
    }

    @Override
    public Nation getSource() {
        return source;
    }

    @Override
    public void setSource(Nation source) {
        this.source = source;
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
    public String toString() {
        StringBuilder toString = new StringBuilder();
        toString.append("\tNATION RELATION INFO: ");
        toString.append(" (id=");
        toString.append(this.getNationRelationId());
        toString.append(")\n");
        toString.append(this.getSource());
        toString.append(this.getDestination());
        toString.append(this.getRelation());
        return toString.toString();
    }
}
