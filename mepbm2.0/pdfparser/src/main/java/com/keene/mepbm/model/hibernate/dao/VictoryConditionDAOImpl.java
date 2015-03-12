package com.keene.mepbm.model.hibernate.dao;

import com.keene.hibernate.dao.HibernateDAO;
import com.keene.mepbm.model.VictoryCondition;
import com.keene.mepbm.model.hibernate.VictoryConditionImpl;
import com.keene.mepbm.model.dao.VictoryConditionDAO;
import com.keene.mepbm.model.hibernate.GameImpl;
import com.keene.mepbm.model.hibernate.NationImpl;
import java.util.List;
import java.util.Properties;

public class VictoryConditionDAOImpl extends HibernateDAO<VictoryConditionImpl> implements VictoryConditionDAO<VictoryConditionImpl,NationImpl,GameImpl> {

    public VictoryConditionDAOImpl() {
    }

    @Override
    public List<VictoryConditionImpl> selectAll() {
        return getHibernateTemplate().loadAll(VictoryConditionImpl.class);
    }

    @Override
    public VictoryCondition load(String description, NationImpl nation, GameImpl game) {
        Properties props = new Properties();
        props.put("description", description);
        props.put("nation_nationId", nation);
        props.put("game_gameId", game);
        VictoryConditionImpl vc = new VictoryConditionImpl();
        vc.setDescription(description);
        vc.setNation(nation);
        vc.setGame(game);
        return super.load(props, vc);
    }
}
