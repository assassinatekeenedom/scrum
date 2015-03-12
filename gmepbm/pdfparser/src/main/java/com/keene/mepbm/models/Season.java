package com.keene.mepbm.models;

public interface Season<T extends TurnNumber> {

    public String getName();

    public void setName(String name);

    public int getSeasonId();

    public void setSeasonId(int seasonId);

}
