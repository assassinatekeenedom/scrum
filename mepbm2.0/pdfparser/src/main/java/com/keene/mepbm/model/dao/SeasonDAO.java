package com.keene.mepbm.model.dao;

import com.keene.dao.DAO;
import com.keene.mepbm.model.Season;

public interface SeasonDAO<S extends Season> extends DAO<S> {

    public Season load(String season);
}
