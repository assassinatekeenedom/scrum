package com.keene.mepbm.model.hibernate;

import com.keene.hibernate.dao.HibernateModel;
import com.keene.mepbm.model.Market;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
//@Table(name="Market")
public class MarketImpl implements Serializable,Market<TurnNumberImpl,MarketPricesImpl,ResourceDetailsImpl,GameImpl>,HibernateModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int marketId;

    @OneToOne()
    private MarketPricesImpl marketPrices;

    @OneToOne()
    private ResourceDetailsImpl resourceDetails;

    @OneToOne()
    private GameImpl game;

    @OneToOne()
    private TurnNumberImpl turnNumber;

    public MarketImpl() {
    }

    @Override
    public int getMarketId() {
        return marketId;
    }

    @Override
    public void setMarketId(int marketId) {
        this.marketId = marketId;
    }

    @Override
    public MarketPricesImpl getMarketPrices() {
        return marketPrices;
    }

    @Override
    public void setMarketPrices(MarketPricesImpl marketPrices) {
        this.marketPrices = marketPrices;
    }

    @Override
    public ResourceDetailsImpl getResourceDetails() {
        return resourceDetails;
    }

    @Override
    public void setResourceDetails(ResourceDetailsImpl resourceDetails) {
        this.resourceDetails = resourceDetails;
    }

    @Override
    public GameImpl getGame() {
        return game;
    }

    @Override
    public void setGame(GameImpl game) {
        this.game = game;
    }

    @Override
    public TurnNumberImpl getTurnNumber() {
        return turnNumber;
    }

    @Override
    public void setTurnNumber(TurnNumberImpl turnNumber) {
        this.turnNumber = turnNumber;
    }
    
    @Override
    public String toString(){
        StringBuilder toString = new StringBuilder();
        toString.append("MARKET INFO:");
        toString.append(" (id=");
        toString.append(this.getMarketId());
        toString.append(")");
        toString.append("\n");
        toString.append(this.getMarketPrices());
        toString.append(this.getResourceDetails());
        return toString.toString();
    }
    
}
