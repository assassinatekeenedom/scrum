package com.keene.mepbm.model.hibernate.dao;

import com.keene.hibernate.dao.HibernateDAO;
import com.keene.mepbm.model.dao.VictoryPointsDAO;
import com.keene.mepbm.model.hibernate.VictoryPointsImpl;
import java.util.List;

public class VictoryPointsDAOImpl extends  HibernateDAO<VictoryPointsImpl> implements VictoryPointsDAO<VictoryPointsImpl> {

    public VictoryPointsDAOImpl() {
    }

    @Override
    public List<VictoryPointsImpl> selectAll() {
        return getHibernateTemplate().loadAll(VictoryPointsImpl.class);
    }
}
