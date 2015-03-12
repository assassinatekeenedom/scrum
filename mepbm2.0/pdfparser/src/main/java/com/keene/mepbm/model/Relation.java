package com.keene.mepbm.model;

public interface Relation<N extends Nation> {

    public int getRelationId();

    public void setRelationId(int relationId);

    public String getRelation();

    public void setRelation(String relation);
    
}
