package com.keene.mepbm.models.impl;

import com.keene.mepbm.models.Relation;

public class RelationImpl implements Relation {

    private int relationId;
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
