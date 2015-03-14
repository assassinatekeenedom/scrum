package com.keene.mepbm.models.impl;

import com.keene.mepbm.models.MarketPrices;
import com.keene.mepbm.models.Nation;
import com.keene.mepbm.models.PopulationCenter;
import com.keene.mepbm.models.ResourceDetails;
import com.keene.mepbm.models.TurnNumber;
import com.keene.mepbm.models.Upkeep;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ResourceDetailsImpl implements ResourceDetails<PopulationCenter, Nation, TurnNumber, MarketPrices, Upkeep> {

    @Id
    @GeneratedValue
    @Column(unique = true)
    private int resourceDetailsId;
    @Column()
    private int leatherStore;
    @Column()
    private int leatherProduction;
    @Column()
    private int bronzeStore;
    @Column()
    private int bronzeProduction;
    @Column()
    private int steelStore;
    @Column()
    private int steelProduction;
    @Column()
    private int mithrilStore;
    @Column()
    private int mithrilProduction;
    @Column()
    private int foodStore;
    @Column()
    private int foodProduction;
    @Column()
    private int timberStore;
    @Column()
    private int timberProduction;
    @Column()
    private int mountsStore;
    @Column()
    private int mountsProduction;
    @Column()
    private int goldStore;
    @Column()
    private int goldProduction;
    @OneToOne
    private PopulationCenterImpl populationCenter;
    @OneToOne
    private NationImpl nation;
    @OneToOne
    private TurnNumberImpl turnNumber;
    @OneToOne
    private MarketPricesImpl marketPrices;
    @OneToOne
    private UpkeepImpl upkeep;

    public ResourceDetailsImpl() {
    }

    @Override
    public int getBronzeProduction() {
        return bronzeProduction;
    }

    @Override
    public void setBronzeProduction(int bronzeProduction) {
        this.bronzeProduction = bronzeProduction;
    }

    @Override
    public int getBronzeStore() {
        return bronzeStore;
    }

    @Override
    public void setBronzeStore(int bronzeStore) {
        this.bronzeStore = bronzeStore;
    }

    @Override
    public int getFoodProduction() {
        return foodProduction;
    }

    @Override
    public void setFoodProduction(int foodProduction) {
        this.foodProduction = foodProduction;
    }

    @Override
    public int getFoodStore() {
        return foodStore;
    }

    @Override
    public void setFoodStore(int foodStore) {
        this.foodStore = foodStore;
    }

    @Override
    public int getGoldProduction() {
        return goldProduction;
    }

    @Override
    public void setGoldProduction(int goldProduction) {
        this.goldProduction = goldProduction;
    }

    @Override
    public int getGoldStore() {
        return goldStore;
    }

    @Override
    public void setGoldStore(int goldStore) {
        this.goldStore = goldStore;
    }

    @Override
    public int getLeatherProduction() {
        return leatherProduction;
    }

    @Override
    public void setLeatherProduction(int leatherProduction) {
        this.leatherProduction = leatherProduction;
    }

    @Override
    public int getLeatherStore() {
        return leatherStore;
    }

    @Override
    public void setLeatherStore(int leatherStore) {
        this.leatherStore = leatherStore;
    }

    @Override
    public int getMithrilProduction() {
        return mithrilProduction;
    }

    @Override
    public void setMithrilProduction(int mithrilProduction) {
        this.mithrilProduction = mithrilProduction;
    }

    @Override
    public int getMithrilStore() {
        return mithrilStore;
    }

    @Override
    public void setMithrilStore(int mithrilStore) {
        this.mithrilStore = mithrilStore;
    }

    @Override
    public int getMountsProduction() {
        return mountsProduction;
    }

    @Override
    public void setMountsProduction(int mountsProduction) {
        this.mountsProduction = mountsProduction;
    }

    @Override
    public int getMountsStore() {
        return mountsStore;
    }

    @Override
    public void setMountsStore(int mountsStore) {
        this.mountsStore = mountsStore;
    }

    @Override
    public int getSteelProduction() {
        return steelProduction;
    }

    @Override
    public void setSteelProduction(int steelProduction) {
        this.steelProduction = steelProduction;
    }

    @Override
    public int getSteelStore() {
        return steelStore;
    }

    @Override
    public void setSteelStore(int steelStore) {
        this.steelStore = steelStore;
    }

    @Override
    public int getTimberProduction() {
        return timberProduction;
    }

    @Override
    public void setTimberProduction(int timberProduction) {
        this.timberProduction = timberProduction;
    }

    @Override
    public int getTimberStore() {
        return timberStore;
    }

    @Override
    public void setTimberStore(int timberStore) {
        this.timberStore = timberStore;
    }

    @Override
    public int getResourceDetailsId() {
        return resourceDetailsId;
    }

    @Override
    public void setResourceDetailsId(int resourceDetailsId) {
        this.resourceDetailsId = resourceDetailsId;
    }

    @Override
    public Nation getNation() {
        return nation;
    }

    @Override
    public void setNation(Nation nation) {
        this.nation = (NationImpl) nation;
    }

    @Override
    public PopulationCenter getPopulationCenter() {
        return populationCenter;
    }

    @Override
    public void setPopulationCenter(PopulationCenter populationCenter) {
        this.populationCenter = (PopulationCenterImpl) populationCenter;
    }

    @Override
    public TurnNumber getTurnNumber() {
        return turnNumber;
    }

    @Override
    public void setTurnNumber(TurnNumber turnNumber) {
        this.turnNumber = (TurnNumberImpl) turnNumber;
    }

    @Override
    public MarketPrices getMarketPrices() {
        return marketPrices;
    }

    @Override
    public void setMarketPrices(MarketPrices marketPrices) {
        this.marketPrices = (MarketPricesImpl) marketPrices;
    }

    @Override
    public Upkeep getUpkeep() {
        return upkeep;
    }

    @Override
    public void setUpkeep(Upkeep upkeep) {
        this.upkeep = (UpkeepImpl) upkeep;
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        toString.append("\tRESOURCE DETAILS INFO: ");
        toString.append(" (id=");
        toString.append(this.getResourceDetailsId());
        toString.append(")\n");
        toString.append("\tProduction: \n");
        toString.append("\t\tLeather - ");
        toString.append(this.leatherProduction);
        toString.append("\tBronze - ");
        toString.append(this.bronzeProduction);
        toString.append("\tSteel - ");
        toString.append(this.steelProduction);
        toString.append("\tMithril - ");
        toString.append(this.mithrilProduction);
        toString.append("\tFood - ");
        toString.append(this.foodProduction);
        toString.append("\tTimber - ");
        toString.append(this.timberProduction);
        toString.append("\tMounts - ");
        toString.append(this.mountsProduction);
        toString.append("\tGold - ");
        toString.append(this.goldProduction);
        toString.append("\n");
        toString.append("\tStores: \n");
        toString.append("\t\tLeather - ");
        toString.append(this.leatherStore);
        toString.append("\tBronze - ");
        toString.append(this.bronzeStore);
        toString.append("\tSteel - ");
        toString.append(this.steelStore);
        toString.append("\tMithril - ");
        toString.append(this.mithrilStore);
        toString.append("\tFood - ");
        toString.append(this.foodStore);
        toString.append("\tTimber - ");
        toString.append(this.timberStore);
        toString.append("\tMounts - ");
        toString.append(this.mountsStore);
        toString.append("\tGold - ");
        toString.append(this.goldStore);
        toString.append("\n");
        return toString.toString();
    }
}
