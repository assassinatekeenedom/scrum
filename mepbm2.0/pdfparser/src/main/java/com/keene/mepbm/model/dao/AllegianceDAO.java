package com.keene.mepbm.model.dao;

import com.keene.dao.DAO;
import com.keene.mepbm.model.Allegiance;

public interface AllegianceDAO<A extends Allegiance> extends DAO<A>{

    public Allegiance load(String allegiance);

}
