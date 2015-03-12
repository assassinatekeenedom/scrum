package com.keene.mepbm.model.hibernate.dao;

import com.keene.hibernate.dao.HibernateDAO;
import com.keene.mepbm.model.Climate;
import com.keene.mepbm.model.hibernate.ClimateImpl;
import com.keene.mepbm.model.dao.ClimateDAO;
import java.util.List;
import java.util.Properties;

public class ClimateDAOImpl extends HibernateDAO<ClimateImpl> implements ClimateDAO<ClimateImpl> {

    public ClimateDAOImpl() {
    }

    @Override
    public List<ClimateImpl> selectAll() {
        return getHibernateTemplate().loadAll(ClimateImpl.class);
    }

    @Override
    public Climate load(String climate){
        Properties props = new Properties();
        props.put("name", climate.toLowerCase().trim());
        ClimateImpl aclimate = new ClimateImpl();
        aclimate.setName(climate.toLowerCase().trim());
        return super.load(props, aclimate);
    }
}
