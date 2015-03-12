package com.keene.mepbm.model.hibernate.dao;

import com.keene.hibernate.dao.HibernateDAO;
import com.keene.mepbm.model.Hex;
import com.keene.mepbm.model.hibernate.HexImpl;
import com.keene.mepbm.model.dao.HexDAO;
import com.keene.mepbm.model.hibernate.ClimateImpl;
import com.keene.mepbm.model.hibernate.TerrainImpl;
import java.util.List;
import java.util.Properties;

public class HexDAOImpl extends HibernateDAO<HexImpl> implements HexDAO<HexImpl, ClimateImpl, TerrainImpl> {

    public HexDAOImpl() {
    }

    @Override
    public List<HexImpl> selectAll() {
        return getHibernateTemplate().loadAll(HexImpl.class);
    }

    @Override
    public Hex load(int hexNumber, ClimateImpl climate, TerrainImpl terrain) {
        Properties props = new Properties();
        props.put("hex", hexNumber);
        HexImpl ahex = new HexImpl();
        ahex.setHex(hexNumber);
        ahex.setClimate(climate);
        ahex.setTerrain(terrain);
        return super.load(props, ahex);
    }
}
