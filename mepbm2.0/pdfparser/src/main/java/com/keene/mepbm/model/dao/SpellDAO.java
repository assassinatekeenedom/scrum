package com.keene.mepbm.model.dao;

import com.keene.dao.DAO;
import com.keene.mepbm.model.Spell;

public interface SpellDAO<S extends Spell> extends DAO<S> {

    public Spell load(String spell);
}
