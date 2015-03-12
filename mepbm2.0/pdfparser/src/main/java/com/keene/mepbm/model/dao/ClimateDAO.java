package com.keene.mepbm.model.dao;

import com.keene.dao.DAO;
import com.keene.mepbm.model.Climate;

public interface ClimateDAO<C extends Climate> extends DAO<C> {

    public Climate load(String climate);

}
