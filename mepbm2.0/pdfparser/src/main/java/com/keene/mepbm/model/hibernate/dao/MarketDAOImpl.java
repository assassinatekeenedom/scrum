package com.keene.mepbm.model.hibernate.dao;

import com.keene.hibernate.dao.HibernateDAO;
import com.keene.mepbm.model.Market;
import com.keene.mepbm.model.dao.MarketDAO;
import com.keene.mepbm.model.hibernate.GameImpl;
import com.keene.mepbm.model.hibernate.MarketImpl;
import com.keene.mepbm.model.hibernate.TurnNumberImpl;
import java.util.List;
import java.util.Properties;

public class MarketDAOImpl extends HibernateDAO<MarketImpl> implements MarketDAO<MarketImpl> {

    public MarketDAOImpl() {
    }

    @Override
    public List<MarketImpl> selectAll() {
        return getHibernateTemplate().loadAll(MarketImpl.class);
    }

    @Override
    public Market load(GameImpl game, TurnNumberImpl turn) {
        Properties props = new Properties();
        props.put("game_gameId", game.getGameId());
        props.put("turnNumber_turnNumberId", turn.getTurnNumberId());
        MarketImpl market = new MarketImpl();
        market.setGame(game);
        market.setTurnNumber(turn);
        return super.load(props, market);
    }
}
