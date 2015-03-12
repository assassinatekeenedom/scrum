package com.keene.mepbm.model.hibernate.dao;

import com.keene.hibernate.dao.HibernateDAO;
import com.keene.mepbm.model.dao.TroopsDAO;
import com.keene.mepbm.model.hibernate.TroopsImpl;
import java.util.List;

public class TroopsDAOImpl extends HibernateDAO<TroopsImpl> implements TroopsDAO<TroopsImpl> {

    public TroopsDAOImpl() {
    }

    @Override
    public List<TroopsImpl> selectAll() {
        return getHibernateTemplate().loadAll(TroopsImpl.class);
    }
}
