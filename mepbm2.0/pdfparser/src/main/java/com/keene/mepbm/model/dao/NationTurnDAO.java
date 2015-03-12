package com.keene.mepbm.model.dao;

import com.keene.dao.DAO;
import com.keene.mepbm.model.NationTurn;
import com.keene.mepbm.model.TurnNumber;
import com.keene.mepbm.model.hibernate.NationImpl;

public interface NationTurnDAO<N extends NationTurn, I extends NationImpl, T extends TurnNumber> extends DAO<N> {

    public NationTurn load(I nation, T turn);

}
