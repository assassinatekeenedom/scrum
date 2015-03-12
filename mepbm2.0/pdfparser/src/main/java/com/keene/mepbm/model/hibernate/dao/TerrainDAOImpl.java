package com.keene.mepbm.model.hibernate.dao;

import com.keene.hibernate.dao.HibernateDAO;
import com.keene.mepbm.model.Terrain;
import com.keene.mepbm.model.hibernate.TerrainImpl;
import com.keene.mepbm.model.dao.TerrainDAO;
import java.util.List;
import java.util.Properties;

public class TerrainDAOImpl extends HibernateDAO<TerrainImpl> implements TerrainDAO<TerrainImpl> {

    public TerrainDAOImpl() {
    }

    @Override
    public List<TerrainImpl> selectAll() {
        return getHibernateTemplate().loadAll(TerrainImpl.class);
    }

    @Override
    public Terrain load(String terrain){
        Properties props = new Properties();
        props.put("name", terrain.toLowerCase().trim());
        TerrainImpl aterrain = new TerrainImpl();
        aterrain.setName(terrain.toLowerCase().trim());
        return super.load(props, aterrain);
    }
}
