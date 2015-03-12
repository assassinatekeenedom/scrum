package com.keene.mepbm.models.impl;

import com.keene.mepbm.models.Game;
import com.keene.mepbm.models.Market;
import com.keene.mepbm.models.MarketPrices;
import com.keene.mepbm.models.ResourceDetails;
import com.keene.mepbm.models.TurnNumber;

public class MarketImpl implements Market<TurnNumber, MarketPrices, ResourceDetails, Game> {

    private int marketId;
    private MarketPrices marketPrices;
    private ResourceDetails resourceDetails;
    private Game game;
    private TurnNumber turnNumber;

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
    public MarketPrices getMarketPrices() {
        return marketPrices;
    }

    @Override
    public void setMarketPrices(MarketPrices marketPrices) {
        this.marketPrices = marketPrices;
    }

    @Override
    public ResourceDetails getResourceDetails() {
        return resourceDetails;
    }

    @Override
    public void setResourceDetails(ResourceDetails resourceDetails) {
        this.resourceDetails = resourceDetails;
    }

    @Override
    public Game getGame() {
        return game;
    }

    @Override
    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public TurnNumber getTurnNumber() {
        return turnNumber;
    }

    @Override
    public void setTurnNumber(TurnNumber turnNumber) {
        this.turnNumber = turnNumber;
    }

    @Override
    public String toString() {
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
