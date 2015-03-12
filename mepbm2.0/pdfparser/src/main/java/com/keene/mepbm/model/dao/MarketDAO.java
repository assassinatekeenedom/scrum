package com.keene.mepbm.model.dao;

import com.keene.dao.DAO;
import com.keene.mepbm.model.Market;
import com.keene.mepbm.model.hibernate.GameImpl;
import com.keene.mepbm.model.hibernate.TurnNumberImpl;

public interface MarketDAO<M extends Market> extends DAO<M> {

    public Market load(GameImpl game, TurnNumberImpl turn);

}
