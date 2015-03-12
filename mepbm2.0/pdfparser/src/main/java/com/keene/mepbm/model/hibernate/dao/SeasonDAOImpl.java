package com.keene.mepbm.model.hibernate.dao;

import com.keene.hibernate.dao.HibernateDAO;
import com.keene.mepbm.model.Season;
import com.keene.mepbm.model.hibernate.SeasonImpl;
import com.keene.mepbm.model.dao.SeasonDAO;
import java.util.List;
import java.util.Properties;

public class SeasonDAOImpl extends HibernateDAO<SeasonImpl> implements SeasonDAO<SeasonImpl> {

    public SeasonDAOImpl() {
    }

    @Override
    public List<SeasonImpl> selectAll() {
        return getHibernateTemplate().loadAll(SeasonImpl.class);
    }

    @Override
    public Season load(String season) {
        Properties props = new Properties();
        props.put("name", season.toLowerCase().trim());
        SeasonImpl aseason = new SeasonImpl();
        aseason.setName(season.toLowerCase().trim());
        return super.load(props, aseason);
    }
}
