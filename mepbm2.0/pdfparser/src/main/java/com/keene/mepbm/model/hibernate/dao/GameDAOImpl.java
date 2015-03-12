package com.keene.mepbm.model.hibernate.dao;

import com.keene.hibernate.dao.HibernateDAO;
import com.keene.mepbm.model.hibernate.GameImpl;
import com.keene.mepbm.model.dao.GameDAO;
import java.util.List;
import java.util.Properties;

public class GameDAOImpl extends HibernateDAO<GameImpl> implements GameDAO<GameImpl> {

    public GameDAOImpl() {
    }

    @Override
    public List<GameImpl> selectAll() {
        return getHibernateTemplate().loadAll(GameImpl.class);
    }

    @Override
    public GameImpl load(int gameNumber, String gameModule) {
        Properties props = new Properties();
        props.put("number", gameNumber);
        props.put("gameModule", gameModule);
        GameImpl game = new GameImpl();            
        game.setNumber(gameNumber);
        game.setModule(gameModule);
        return super.load(props, game);
    }

}
