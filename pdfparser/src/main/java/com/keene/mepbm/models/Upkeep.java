package com.keene.mepbm.models;

public interface Upkeep {

    public int getArmiesAndNavies();

    public void setArmiesAndNavies(int armiesAndNavies);

    public int getCharacters();

    public void setCharacters(int characters);

    public int getGrossGold();

    public void setGrossGold(int grossGold);

    public int getNetGold();

    public void setNetGold(int netGold);

    public int getPopCenters();

    public void setPopCenters(int popCenters);

    public int getReserves();

    public void setReserves(int reserves);

    public int getTotalUpkeep();
    
    public void setTotalUpkeep(int totalUpkeep);

    public int getUpkeepId();

    public void setUpkeepId(int upkeepId);

    public int getTaxRate();
    
    public void setTaxRate(int taxRate);
}
