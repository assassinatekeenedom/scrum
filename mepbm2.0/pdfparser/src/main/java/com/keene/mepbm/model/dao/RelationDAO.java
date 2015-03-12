package com.keene.mepbm.model.dao;

import com.keene.dao.DAO;
import com.keene.mepbm.model.Relation;

public interface RelationDAO<R extends Relation> extends DAO<R> {

    public Relation load(String relation);

}
