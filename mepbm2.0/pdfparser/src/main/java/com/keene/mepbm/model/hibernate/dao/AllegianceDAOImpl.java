package com.keene.mepbm.model.hibernate.dao;

import com.keene.hibernate.dao.HibernateDAO;
import com.keene.mepbm.model.Allegiance;
import com.keene.mepbm.model.hibernate.AllegianceImpl;
import com.keene.mepbm.model.dao.AllegianceDAO;
import java.util.List;
import java.util.Properties;

public class AllegianceDAOImpl extends HibernateDAO<AllegianceImpl> implements AllegianceDAO<AllegianceImpl> {

    public AllegianceDAOImpl() {
    }

    @Override
    public List<AllegianceImpl> selectAll() {
        return getHibernateTemplate().loadAll(AllegianceImpl.class);
    }

    @Override
    public Allegiance load(String allegiance) {
        Properties props = new Properties();
        props.put("allegianceName", allegiance.toLowerCase().trim());
        AllegianceImpl anallegiance = new AllegianceImpl();
        anallegiance.setAllegianceName(allegiance.toLowerCase().trim());
        return super.load(props, anallegiance);
    }
}
