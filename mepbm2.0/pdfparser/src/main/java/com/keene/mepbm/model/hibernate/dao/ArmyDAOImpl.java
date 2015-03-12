package com.keene.mepbm.model.hibernate.dao;

import com.keene.hibernate.dao.HibernateDAO;
import com.keene.mepbm.model.Army;
import com.keene.mepbm.model.hibernate.ArmyImpl;
import com.keene.mepbm.model.hibernate.CharacterImpl;
import com.keene.mepbm.model.hibernate.TurnNumberImpl;
import com.keene.mepbm.model.dao.ArmyDAO;
import java.util.List;
import java.util.Properties;

public class ArmyDAOImpl extends HibernateDAO<ArmyImpl> implements ArmyDAO<ArmyImpl,CharacterImpl,TurnNumberImpl> {

    public ArmyDAOImpl() {
    }

    @Override
    public List<ArmyImpl> selectAll() {
        return getHibernateTemplate().loadAll(ArmyImpl.class);
    }

    @Override
    public Army load(CharacterImpl commander, TurnNumberImpl turn) {
        Properties props = new Properties();
        props.put("armyCommander_characterId", commander.getCharacterId());
        props.put("turnNumber_turnNumberId", turn.getTurnNumberId());
        ArmyImpl army = new ArmyImpl();
        army.setArmyCommander(commander);
        army.setTurnNumber(turn);
        return super.load(props, army);
    }
}
