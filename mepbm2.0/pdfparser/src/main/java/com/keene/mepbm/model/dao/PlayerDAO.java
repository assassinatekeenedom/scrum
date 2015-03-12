package com.keene.mepbm.model.dao;

import com.keene.dao.DAO;
import com.keene.mepbm.model.Player;

public interface PlayerDAO<P extends Player> extends DAO<P> {

    public Player load(String name, int accountNumber);
}
