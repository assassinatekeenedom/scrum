package com.keene.mepbm.model.hibernate.dao;

import com.keene.hibernate.dao.HibernateDAO;
import com.keene.mepbm.model.Character;
import com.keene.mepbm.model.Game;
import com.keene.mepbm.model.TurnNumber;
import com.keene.mepbm.model.hibernate.CharacterImpl;
import com.keene.mepbm.model.hibernate.GameImpl;
import com.keene.mepbm.model.dao.CharacterDAO;
import com.keene.mepbm.model.hibernate.TurnNumberImpl;
import java.util.List;
import java.util.Properties;

public class CharacterDAOImpl extends HibernateDAO<CharacterImpl> implements CharacterDAO<CharacterImpl> {

    public CharacterDAOImpl() {
    }

    @Override
    public List<CharacterImpl> selectAll() {
        return getHibernateTemplate().loadAll(CharacterImpl.class);
    }

    @Override
    public Character load(String character, Game game, TurnNumber turn) {
        while(character.length()<5){
            character += " ";
        }
        character = character.substring(0, 5).toLowerCase();
        Properties props = new Properties();
        props.put("name", character);
        props.put("game_gameId", game.getGameId());
        props.put("turnNumber_turnNumberId", turn.getTurnNumberId());
        CharacterImpl newtoon = new CharacterImpl();
        newtoon.setName(character);
        newtoon.setGame((GameImpl) game);
        newtoon.setTurnNumber((TurnNumberImpl)turn);
        return super.load(props, newtoon);
    }
}
