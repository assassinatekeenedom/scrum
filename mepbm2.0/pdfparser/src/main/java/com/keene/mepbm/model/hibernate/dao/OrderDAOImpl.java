package com.keene.mepbm.model.hibernate.dao;

import com.keene.hibernate.dao.HibernateDAO;
import com.keene.mepbm.model.dao.OrderDAO;
import com.keene.mepbm.model.hibernate.OrderImpl;
import java.util.List;


public class OrderDAOImpl extends HibernateDAO<OrderImpl> implements OrderDAO<OrderImpl> {

    public OrderDAOImpl() {
    }

    @Override
    public List<OrderImpl> selectAll() {
        return getHibernateTemplate().loadAll(OrderImpl.class);
    }
}
