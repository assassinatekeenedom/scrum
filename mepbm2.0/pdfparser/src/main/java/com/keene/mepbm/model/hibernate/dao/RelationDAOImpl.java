package com.keene.mepbm.model.hibernate.dao;

import com.keene.hibernate.dao.HibernateDAO;
import com.keene.mepbm.model.Relation;
import com.keene.mepbm.model.dao.RelationDAO;
import com.keene.mepbm.model.hibernate.RelationImpl;
import java.util.List;
import java.util.Properties;

public class RelationDAOImpl extends HibernateDAO<RelationImpl> implements RelationDAO<RelationImpl> {

    public RelationDAOImpl() {
    }

    @Override
    public List<RelationImpl> selectAll() {
        return getHibernateTemplate().loadAll(RelationImpl.class);
    }

    @Override
    public Relation load(String relation) {
        Properties props = new Properties();
        props.put("relation", relation.toLowerCase().trim());
        RelationImpl arelation = new RelationImpl();
        arelation.setRelation(relation.toLowerCase().trim());
        return super.load(props, arelation);
    }
}
