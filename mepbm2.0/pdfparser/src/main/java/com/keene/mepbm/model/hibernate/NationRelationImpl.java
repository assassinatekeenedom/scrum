package com.keene.mepbm.model.hibernate;

import com.keene.hibernate.dao.HibernateModel;
import com.keene.mepbm.model.NationRelation;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
//@Table(name="NationRelation")
public class NationRelationImpl implements Serializable, NationRelation<TurnNumberImpl, RelationImpl, NationImpl, NationTurnImpl>, HibernateModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int nationRelationId;
    @OneToOne
    private TurnNumberImpl turnNumber;
    @OneToOne
    private NationImpl source;
    @OneToOne
    private NationImpl destination;
    @OneToOne
    private RelationImpl relation;
    @OneToOne
    private NationTurnImpl nationTurn;

    public NationRelationImpl() {
    }

    @Override
    public RelationImpl getRelation() {
        return relation;
    }

    @Override
    public void setRelation(RelationImpl relation) {
        this.relation = relation;
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
    public int getNationRelationId() {
        return nationRelationId;
    }

    @Override
    public void setNationRelationId(int nationRelationId) {
        this.nationRelationId = nationRelationId;
    }

    @Override
    public NationImpl getDestination() {
        return destination;
    }

    @Override
    public void setDestination(NationImpl destination) {
        this.destination = destination;
    }

    @Override
    public NationImpl getSource() {
        return source;
    }

    @Override
    public void setSource(NationImpl source) {
        this.source = source;
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
