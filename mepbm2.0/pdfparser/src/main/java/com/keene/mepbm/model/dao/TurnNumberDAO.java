package com.keene.mepbm.model.dao;

import com.keene.dao.DAO;
import com.keene.mepbm.model.Game;
import com.keene.mepbm.model.TurnNumber;

public interface TurnNumberDAO<T extends TurnNumber, G extends Game> extends DAO<T> {

    public T load(int turnNumber, G game);
    
}
