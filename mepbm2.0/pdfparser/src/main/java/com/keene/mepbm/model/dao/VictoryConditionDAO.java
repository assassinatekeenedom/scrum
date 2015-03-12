package com.keene.mepbm.model.dao;

import com.keene.dao.DAO;
import com.keene.mepbm.model.Game;
import com.keene.mepbm.model.Nation;
import com.keene.mepbm.model.VictoryCondition;

public interface VictoryConditionDAO<V extends VictoryCondition, N extends Nation, G extends Game> extends DAO<V> {

    public VictoryCondition load(String description, N nation, G game);
}
