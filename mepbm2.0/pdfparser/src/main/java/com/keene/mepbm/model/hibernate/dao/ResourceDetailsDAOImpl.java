package com.keene.mepbm.model.hibernate.dao;

import com.keene.hibernate.dao.HibernateDAO;
import com.keene.mepbm.model.dao.ResourceDetailsDAO;
import com.keene.mepbm.model.hibernate.ResourceDetailsImpl;
import java.util.List;

public class ResourceDetailsDAOImpl extends HibernateDAO<ResourceDetailsImpl> implements ResourceDetailsDAO<ResourceDetailsImpl> {

    public ResourceDetailsDAOImpl() {
    }

    @Override
    public List<ResourceDetailsImpl> selectAll() {
        return getHibernateTemplate().loadAll(ResourceDetailsImpl.class);
    }
}
