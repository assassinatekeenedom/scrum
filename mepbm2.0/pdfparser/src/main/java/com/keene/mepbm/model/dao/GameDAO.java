package com.keene.mepbm.model.dao;

import com.keene.dao.DAO;
import com.keene.mepbm.model.Game;

public interface GameDAO<G extends Game> extends DAO<G>{

    public G load(int gameNumber, String gameModule);
}
