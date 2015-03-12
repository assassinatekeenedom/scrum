package com.keene.mepbm.model.hibernate.dao;

import com.keene.hibernate.dao.HibernateDAO;
import com.keene.mepbm.model.dao.NationRelationDAO;
import com.keene.mepbm.model.hibernate.NationRelationImpl;
import java.util.List;

public class NationRelationDAOImpl extends HibernateDAO<NationRelationImpl> implements NationRelationDAO<NationRelationImpl> {

    public NationRelationDAOImpl() {
    }

    @Override
    public List<NationRelationImpl> selectAll() {
        return getHibernateTemplate().loadAll(NationRelationImpl.class);
    }
}
