package com.keene.mepbm.model.dao;

import com.keene.dao.DAO;
import com.keene.mepbm.model.Character;
import com.keene.mepbm.model.Game;
import com.keene.mepbm.model.TurnNumber;

public interface CharacterDAO<C extends Character> extends DAO<C> {

    public Character load(String character, Game game, TurnNumber T);
    
}
