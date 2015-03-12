package com.keene.mepbm.model.hibernate;

import com.keene.hibernate.dao.HibernateModel;
import com.keene.mepbm.model.MarketPrices;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@Table(name="MarketPrices")
public class MarketPricesImpl implements Serializable, MarketPrices,HibernateModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int marketPricesId;
    @Column
    private int leatherBuyPrice;
    @Column
    private int leatherSellPrice;
    @Column
    private int bronzeBuyPrice;
    @Column
    private int bronzeSellPrice;
    @Column
    private int steelBuyPrice;
    @Column
    private int steelSellPrice;
    @Column
    private int mithrilBuyPrice;
    @Column
    private int mithrilSellPrice;
    @Column
    private int foodBuyPrice;
    @Column
    private int foodSellPrice;
    @Column
    private int timberBuyPrice;
    @Column
    private int timberSellPrice;
    @Column
    private int mountsBuyPrice;
    @Column
    private int mountsSellPrice;
    @Column
    private int goldBuyPrice;
    @Column
    private int goldSellPrice;

    public MarketPricesImpl() {
    }

    @Override
    public int getBronzeSellPrice() {
        return bronzeSellPrice;
    }

    @Override
    public void setBronzeSellPrice(int bronzeSellPrice) {
        this.bronzeSellPrice = bronzeSellPrice;
    }

    @Override
    public int getBronzeBuyPrice() {
        return bronzeBuyPrice;
    }

    @Override
    public void setBronzeBuyPrice(int bronzeBuyPrice) {
        this.bronzeBuyPrice = bronzeBuyPrice;
    }

    @Override
    public int getFoodSellPrice() {
        return foodSellPrice;
    }

    @Override
    public void setFoodSellPrice(int foodSellPrice) {
        this.foodSellPrice = foodSellPrice;
    }

    @Override
    public int getFoodBuyPrice() {
        return foodBuyPrice;
    }

    @Override
    public void setFoodBuyPrice(int foodBuyPrice) {
        this.foodBuyPrice = foodBuyPrice;
    }

    @Override
    public int getGoldSellPrice() {
        return goldSellPrice;
    }

    @Override
    public void setGoldSellPrice(int goldSellPrice) {
        this.goldSellPrice = goldSellPrice;
    }

    @Override
    public int getGoldBuyPrice() {
        return goldBuyPrice;
    }

    @Override
    public void setGoldBuyPrice(int goldBuyPrice) {
        this.goldBuyPrice = goldBuyPrice;
    }

    @Override
    public int getLeatherSellPrice() {
        return leatherSellPrice;
    }

    @Override
    public void setLeatherSellPrice(int leatherSellPrice) {
        this.leatherSellPrice = leatherSellPrice;
    }

    @Override
    public int getLeatherBuyPrice() {
        return leatherBuyPrice;
    }

    @Override
    public void setLeatherBuyPrice(int leatherBuyPrice) {
        this.leatherBuyPrice = leatherBuyPrice;
    }

    @Override
    public int getMithrilSellPrice() {
        return mithrilSellPrice;
    }

    @Override
    public void setMithrilSellPrice(int mithrilSellPrice) {
        this.mithrilSellPrice = mithrilSellPrice;
    }

    @Override
    public int getMithrilBuyPrice() {
        return mithrilBuyPrice;
    }

    @Override
    public void setMithrilBuyPrice(int mithrilBuyPrice) {
        this.mithrilBuyPrice = mithrilBuyPrice;
    }

    @Override
    public int getMountsSellPrice() {
        return mountsSellPrice;
    }

    @Override
    public void setMountsSellPrice(int mountsSellPrice) {
        this.mountsSellPrice = mountsSellPrice;
    }

    @Override
    public int getMountsBuyPrice() {
        return mountsBuyPrice;
    }

    @Override
    public void setMountsBuyPrice(int mountsBuyPrice) {
        this.mountsBuyPrice = mountsBuyPrice;
    }

    @Override
    public int getSteelSellPrice() {
        return steelSellPrice;
    }

    @Override
    public void setSteelSellPrice(int steelSellPrice) {
        this.steelSellPrice = steelSellPrice;
    }

    @Override
    public int getSteelBuyPrice() {
        return steelBuyPrice;
    }

    @Override
    public void setSteelBuyPrice(int steelBuyPrice) {
        this.steelBuyPrice = steelBuyPrice;
    }

    @Override
    public int getTimberSellPrice() {
        return timberSellPrice;
    }

    @Override
    public void setTimberSellPrice(int timberSellPrice) {
        this.timberSellPrice = timberSellPrice;
    }

    @Override
    public int getTimberBuyPrice() {
        return timberBuyPrice;
    }

    @Override
    public void setTimberBuyPrice(int timberBuyPrice) {
        this.timberBuyPrice = timberBuyPrice;
    }

    @Override
    public int getMarketPricesId() {
        return marketPricesId;
    }
    @Override
    public void setMarketPricesId(int marketPricesId) {
        this.marketPricesId = marketPricesId;
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        toString.append("\tMARKET PRICES INFO: ");
        toString.append(" (id=");
        toString.append(this.getMarketPricesId());
        toString.append(")\n");
        toString.append("\tSellPrice: \n");
        toString.append("\t\tLeather - ");
        toString.append(this.leatherSellPrice);
        toString.append("\tBronze - ");
        toString.append(this.bronzeSellPrice);
        toString.append("\tSteel - ");
        toString.append(this.steelSellPrice);
        toString.append("\tMithril - ");
        toString.append(this.mithrilSellPrice);
        toString.append("\tFood - ");
        toString.append(this.foodSellPrice);
        toString.append("\tTimber - ");
        toString.append(this.timberSellPrice);
        toString.append("\tMounts - ");
        toString.append(this.mountsSellPrice);
        toString.append("\tGold - ");
        toString.append(this.goldSellPrice);
        toString.append("\n");
        toString.append("\tBuyPrices: \n");
        toString.append("\t\tLeather - ");
        toString.append(this.leatherBuyPrice);
        toString.append("\tBronze - ");
        toString.append(this.bronzeBuyPrice);
        toString.append("\tSteel - ");
        toString.append(this.steelBuyPrice);
        toString.append("\tMithril - ");
        toString.append(this.mithrilBuyPrice);
        toString.append("\tFood - ");
        toString.append(this.foodBuyPrice);
        toString.append("\tTimber - ");
        toString.append(this.timberBuyPrice);
        toString.append("\tMounts - ");
        toString.append(this.mountsBuyPrice);
        toString.append("\tGold - ");
        toString.append(this.goldBuyPrice);
        toString.append("\n");
        return toString.toString();
    }
    
}
