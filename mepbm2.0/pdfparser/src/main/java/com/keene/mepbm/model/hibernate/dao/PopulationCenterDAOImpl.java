package com.keene.mepbm.model.hibernate.dao;

import com.keene.hibernate.dao.HibernateDAO;
import com.keene.mepbm.model.dao.PopulationCenterDAO;
import com.keene.mepbm.model.hibernate.PopulationCenterImpl;
import java.util.List;

public class PopulationCenterDAOImpl extends HibernateDAO<PopulationCenterImpl> implements PopulationCenterDAO<PopulationCenterImpl> {

    public PopulationCenterDAOImpl() {
    }

    @Override
    public List<PopulationCenterImpl> selectAll() {
        return getHibernateTemplate().loadAll(PopulationCenterImpl.class);
    }
}
