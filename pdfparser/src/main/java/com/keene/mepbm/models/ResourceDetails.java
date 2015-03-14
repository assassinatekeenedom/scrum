package com.keene.mepbm.models;

public interface ResourceDetails<P extends PopulationCenter, N extends Nation, T extends TurnNumber, M extends MarketPrices, U extends Upkeep> {

    public int getBronzeProduction();

    public void setBronzeProduction(int bronzeProduction);

    public int getBronzeStore();

    public void setBronzeStore(int bronzeStore);

    public int getFoodProduction();

    public void setFoodProduction(int foodProduction);

    public int getFoodStore();

    public void setFoodStore(int foodStore);

    public int getGoldProduction();

    public void setGoldProduction(int goldProduction);

    public int getGoldStore();

    public void setGoldStore(int goldStore);

    public int getLeatherProduction();

    public void setLeatherProduction(int leatherProduction);

    public int getLeatherStore();

    public void setLeatherStore(int leatherStore);

    public int getMithrilProduction();

    public void setMithrilProduction(int mithrilProduction);

    public int getMithrilStore();

    public void setMithrilStore(int mithrilStore);

    public int getMountsProduction();

    public void setMountsProduction(int mountsProduction);

    public int getMountsStore();

    public void setMountsStore(int mountsStore);

    public int getSteelProduction();

    public void setSteelProduction(int steelProduction);

    public int getSteelStore();

    public void setSteelStore(int steelStore);

    public int getTimberProduction();

    public void setTimberProduction(int timberProduction);

    public int getTimberStore();

    public void setTimberStore(int timberStore);

    public N getNation();

    public void setNation(N nation);

    public P getPopulationCenter();

    public void setPopulationCenter(P populationCenter);

    public T getTurnNumber();

    public void setTurnNumber(T turnNumber);

    public int getResourceDetailsId();
    
    public void setResourceDetailsId(int resourceDetailsId);

    public M getMarketPrices();

    public void setMarketPrices(M marketPrices);

    public U getUpkeep();
    public void setUpkeep(U upkeep);
}
