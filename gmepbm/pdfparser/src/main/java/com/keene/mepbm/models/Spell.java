package com.keene.mepbm.models;

public interface Spell<C extends Character> {

    public C getCharacter();

    public void setCharacter(C character);

    public int getSpellId();

    public void setSpellId(int climateId);

    public String getName();

    public void setName(String name);

    public int getNumber();

    public void setNumber(int number);

    public int getOrderNumber();

    public void setOrderNumber(int orderNumber);

    public int getProficiency();

    public void setProficiency(int proficiency);
}
