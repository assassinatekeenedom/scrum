package com.keene.mepbm.model.hibernate.dao;

import com.keene.hibernate.dao.HibernateDAO;
import com.keene.mepbm.model.Player;
import com.keene.mepbm.model.hibernate.PlayerImpl;
import com.keene.mepbm.model.dao.PlayerDAO;
import java.util.List;
import java.util.Properties;

public class PlayerDAOImpl extends HibernateDAO<PlayerImpl> implements PlayerDAO<PlayerImpl> {

    public PlayerDAOImpl() {
    }

    @Override
    public List<PlayerImpl> selectAll() {
        return getHibernateTemplate().loadAll(PlayerImpl.class);
    }

    @Override
    public Player load(String name, int accountNumber) {
        Properties props = new Properties();
        props.put("name", name.toLowerCase().trim());
        props.put("accountNumber", accountNumber);
        PlayerImpl player = new PlayerImpl();
        player.setName(name.toLowerCase().trim());
        player.setAccountNumber(accountNumber);
        return super.load(props, player);
    }
}
