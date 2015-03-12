package com.keene.mepbm.model.hibernate.dao;

import com.keene.hibernate.dao.HibernateDAO;
import com.keene.mepbm.model.Nation;
import com.keene.mepbm.model.hibernate.NationImpl;
import com.keene.mepbm.model.dao.NationDAO;
import com.keene.mepbm.model.hibernate.GameImpl;
import java.util.List;
import java.util.Properties;

public class NationDAOImpl extends HibernateDAO<NationImpl> implements NationDAO<NationImpl,GameImpl> {

    public NationDAOImpl() {
    }

    @Override
    public List<NationImpl> selectAll() {
        return getHibernateTemplate().loadAll(NationImpl.class);
    }

    @Override
    public Nation load(String name, GameImpl game) {
        Properties props = new Properties();
        props.put("name", name.toLowerCase().trim());
        props.put("game_gameId", game.getGameId());
        NationImpl nation = new NationImpl();
        nation.setName(name.toLowerCase().trim());
        nation.setGame(game);
        return super.load(props, nation);
    }
}
