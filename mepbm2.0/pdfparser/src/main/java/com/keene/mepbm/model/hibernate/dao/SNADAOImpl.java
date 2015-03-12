package com.keene.mepbm.model.hibernate.dao;

import com.keene.hibernate.dao.HibernateDAO;
import com.keene.mepbm.model.SNA;
import com.keene.mepbm.model.hibernate.SNAImpl;
import com.keene.mepbm.model.dao.SNADAO;
import java.util.List;
import java.util.Properties;

public class SNADAOImpl extends HibernateDAO<SNAImpl> implements SNADAO<SNAImpl> {

    public SNADAOImpl() {
    }

    @Override
    public List<SNAImpl> selectAll() {
        return getHibernateTemplate().loadAll(SNAImpl.class);
    }

    @Override
    public SNA load(int number, String description) {
        Properties props = new Properties();
        props.put("number", number);
        props.put("description", description);
        SNAImpl sna = new SNAImpl();
        sna.setNumber(number);
        sna.setDescription(description);
        return super.load(props, sna);
    }
}
