package com.keene.mepbm.model.hibernate.dao;

import com.keene.hibernate.dao.HibernateDAO;
import com.keene.mepbm.model.Spell;
import com.keene.mepbm.model.hibernate.SpellImpl;
import com.keene.mepbm.model.dao.SpellDAO;
import java.util.List;
import java.util.Properties;

public class SpellDAOImpl extends HibernateDAO<SpellImpl> implements SpellDAO<SpellImpl> {

    public SpellDAOImpl() {
    }

    @Override
    public List<SpellImpl> selectAll() {
        return getHibernateTemplate().loadAll(SpellImpl.class);
    }

    @Override
    public Spell load(String spell) {
        Properties props = new Properties();
        props.put("name", spell.toLowerCase());
        SpellImpl aspell = new SpellImpl();
        aspell.setName(spell.toLowerCase());
        return super.load(props, aspell);
    }
}
