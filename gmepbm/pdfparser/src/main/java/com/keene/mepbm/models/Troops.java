package com.keene.mepbm.models;

public interface Troops<A extends Army> {

    public int getArmor();

    public void setArmor(int armor);

    public int getTroopsId();

    public void setTroopsId(int troopsId);

    public String getDescription();

    public void setDescription(String description);

    public int getNumbers();

    public void setNumbers(int numbers);

    public int getTraining();

    public void setTraining(int training);

    public String getTroopType();

    public void setTroopType(String troopType);

    public int getWeapons();

    public void setWeapons(int weapons);

    public A getArmy();

    public void setArmy(A army);
}
