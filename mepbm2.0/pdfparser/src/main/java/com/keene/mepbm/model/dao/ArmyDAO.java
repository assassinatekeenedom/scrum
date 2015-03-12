package com.keene.mepbm.model.dao;

import com.keene.dao.DAO;
import com.keene.mepbm.model.Army;
import com.keene.mepbm.model.TurnNumber;
import com.keene.mepbm.model.Character;

public interface ArmyDAO<A extends Army, C extends Character, T extends TurnNumber> extends DAO<A>{

    public Army load(C commander, T turn);

}
