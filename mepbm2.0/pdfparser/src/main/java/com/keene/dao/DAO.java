package com.keene.dao;

import java.util.List;
import java.util.Properties;

public interface DAO<O extends Object> {

    public List<O> selectAll();

    public List<O> select(Properties props, O model);

    public O selectUnique(Properties props, O model);

    public O save(O object);

    public O load(Properties props, O model);
}
