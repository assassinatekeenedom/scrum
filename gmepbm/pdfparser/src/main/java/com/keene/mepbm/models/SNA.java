package com.keene.mepbm.models;

public interface SNA<N extends Nation> {

    public String getDescription();

    public void setDescription(String description);

    public int getNumber();

    public void setNumber(int number);

    public int getSnaId();

    public void setSnaId(int snaId);

    public N getNation();

    public void setNation(N nation);

}
