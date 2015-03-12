package com.keene.mepbm.model;

public interface Market<T extends TurnNumber, M extends MarketPrices, R extends ResourceDetails, G extends Game> {

    public int getMarketId();

    public void setMarketId(int marketId);

    public M getMarketPrices();

    public void setMarketPrices(M marketPrices);

    public R getResourceDetails();

    public void setResourceDetails(R unitsAvailable);

    public G getGame();

    public void setGame(G game);

    public T getTurnNumber();

    public void setTurnNumber(T turnNumber);
}
