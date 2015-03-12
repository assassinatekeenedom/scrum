package com.keene.mepbm.model.hibernate;

import com.keene.hibernate.dao.HibernateModel;
import com.keene.mepbm.model.Relation;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@Table(name="Relation")
public class RelationImpl implements Serializable, Relation, HibernateModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int relationId;

    @Column(unique = true)
    private String relation;   

    public RelationImpl() {
    }

    @Override
    public int getRelationId() {
        return relationId;
    }

    @Override
    public void setRelationId(int relationId) {
        this.relationId = relationId;
    }

    @Override
    public String getRelation() {
        return relation;
    }

    @Override
    public void setRelation(String relation) {
        this.relation = relation;
    }   

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        toString.append("\tRELATION INFO: ");
        toString.append(" (id=");
        toString.append(this.getRelationId());
        toString.append(")\n");
        toString.append("\t\tRelation: ");
        toString.append(this.getRelation());
        toString.append("\n");        
        return toString.toString();
    }
}
