package com.keene.mepbm.model.dao;

import com.keene.dao.DAO;
import com.keene.mepbm.model.SNA;

public interface SNADAO<S extends SNA> extends DAO<S> {

    public SNA load(int number, String description);
}
