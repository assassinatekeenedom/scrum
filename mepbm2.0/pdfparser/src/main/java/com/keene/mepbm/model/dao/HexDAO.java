package com.keene.mepbm.model.dao;

import com.keene.dao.DAO;
import com.keene.mepbm.model.Climate;
import com.keene.mepbm.model.Hex;
import com.keene.mepbm.model.Terrain;

public interface HexDAO<H extends Hex, C extends Climate, T extends Terrain> extends DAO<H> {

    public Hex load(int hexNumber, C climate, T terrain);
}
