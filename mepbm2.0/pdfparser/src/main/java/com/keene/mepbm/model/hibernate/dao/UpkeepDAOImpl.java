package com.keene.mepbm.model.hibernate.dao;

import com.keene.hibernate.dao.HibernateDAO;
import com.keene.mepbm.model.dao.UpkeepDAO;
import com.keene.mepbm.model.hibernate.UpkeepImpl;
import java.util.List;

public class UpkeepDAOImpl extends HibernateDAO<UpkeepImpl> implements UpkeepDAO<UpkeepImpl> {

    public UpkeepDAOImpl() {
    }

    @Override
    public List<UpkeepImpl> selectAll() {
        return getHibernateTemplate().loadAll(UpkeepImpl.class);
    }

}
