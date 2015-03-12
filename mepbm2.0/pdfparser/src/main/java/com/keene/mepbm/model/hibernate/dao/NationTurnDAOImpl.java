package com.keene.mepbm.model.hibernate.dao;

import com.keene.hibernate.dao.HibernateDAO;
import com.keene.mepbm.model.NationTurn;
import com.keene.mepbm.model.dao.NationTurnDAO;
import com.keene.mepbm.model.hibernate.NationImpl;
import com.keene.mepbm.model.hibernate.NationTurnImpl;
import com.keene.mepbm.model.hibernate.TurnNumberImpl;
import java.util.List;
import java.util.Properties;


public class NationTurnDAOImpl extends HibernateDAO<NationTurnImpl> implements NationTurnDAO<NationTurnImpl,NationImpl,TurnNumberImpl> {

    public NationTurnDAOImpl() {
    }

    @Override
    public List<NationTurnImpl> selectAll() {
        return getHibernateTemplate().loadAll(NationTurnImpl.class);
    }

    @Override
    public NationTurn load(NationImpl nation, TurnNumberImpl turn) {
        Properties props = new Properties();
        props.put("nation_nationId", nation.getNationId());
        props.put("turnNumber_turnNumberId", turn.getTurnNumberId());
        NationTurnImpl nationTurn = new NationTurnImpl();
        nationTurn.setNation(nation);
        nationTurn.setTurnNumber(turn);
        return super.load(props, nationTurn);
    }

}
