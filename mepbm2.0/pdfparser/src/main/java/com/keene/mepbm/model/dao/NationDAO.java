package com.keene.mepbm.model.dao;

import com.keene.dao.DAO;
import com.keene.mepbm.model.Game;
import com.keene.mepbm.model.Nation;

public interface NationDAO<N extends Nation,G extends Game> extends DAO<N> {

    public Nation load(String name, G game);
    
}
