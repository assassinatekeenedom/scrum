package com.keene.mepbm.model.dao;

import com.keene.dao.DAO;
import com.keene.mepbm.model.Terrain;

public interface TerrainDAO<T extends Terrain> extends DAO<T> {

    public Terrain load(String terrain);
}
