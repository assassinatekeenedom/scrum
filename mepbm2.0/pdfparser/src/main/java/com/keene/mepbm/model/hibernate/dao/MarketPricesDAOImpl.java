package com.keene.mepbm.model.hibernate.dao;

import com.keene.hibernate.dao.HibernateDAO;
import com.keene.mepbm.model.dao.MarketPricesDAO;
import com.keene.mepbm.model.hibernate.MarketPricesImpl;
import java.util.List;

public class MarketPricesDAOImpl extends HibernateDAO<MarketPricesImpl> implements MarketPricesDAO<MarketPricesImpl> {

    public MarketPricesDAOImpl() {
    }

    @Override
    public List<MarketPricesImpl> selectAll() {
        return getHibernateTemplate().loadAll(MarketPricesImpl.class);
    }
}
