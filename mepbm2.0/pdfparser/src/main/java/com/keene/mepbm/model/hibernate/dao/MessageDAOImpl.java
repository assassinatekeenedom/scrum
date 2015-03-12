package com.keene.mepbm.model.hibernate.dao;

import com.keene.hibernate.dao.HibernateDAO;
import com.keene.mepbm.model.dao.MessageDAO;
import com.keene.mepbm.model.hibernate.MessageImpl;
import java.util.List;

public class MessageDAOImpl extends HibernateDAO<MessageImpl> implements MessageDAO<MessageImpl> {

    public MessageDAOImpl() {
    }

    @Override
    public List<MessageImpl> selectAll() {
        return getHibernateTemplate().loadAll(MessageImpl.class);
    }
}
