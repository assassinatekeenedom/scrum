package com.keene.mepbm.model.hibernate.dao;

import com.keene.hibernate.dao.HibernateDAO;
import com.keene.mepbm.model.hibernate.TurnNumberImpl;
import com.keene.mepbm.model.dao.TurnNumberDAO;
import com.keene.mepbm.model.hibernate.GameImpl;
import java.util.List;
import java.util.Properties;

public class TurnNumberDAOImpl extends HibernateDAO<TurnNumberImpl> implements TurnNumberDAO<TurnNumberImpl, GameImpl> {

    public TurnNumberDAOImpl() {
    }

    @Override
    public List<TurnNumberImpl> selectAll() {
        return getHibernateTemplate().loadAll(TurnNumberImpl.class);
    }

    @Override
    public TurnNumberImpl load(int number, GameImpl game) {
        Properties props = new Properties();
        props.put("game_gameId", game.getGameId());
        props.put("number", number);
        TurnNumberImpl turn = new TurnNumberImpl();
        turn.setGame(game);
        turn.setNumber(number);
        return super.load(props, turn);
    }
}
