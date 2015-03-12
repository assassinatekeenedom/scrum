package com.keene.mepbm.reader.pdf.section;

import com.keene.mepbm.model.Market;
import com.keene.mepbm.model.MarketPrices;
import com.keene.mepbm.model.ResourceDetails;
import com.keene.mepbm.model.hibernate.GameImpl;
import com.keene.mepbm.model.hibernate.MarketPricesImpl;
import com.keene.mepbm.model.hibernate.ResourceDetailsImpl;
import com.keene.mepbm.model.hibernate.TurnNumberImpl;

public final class TurnMarket extends TurnPDFSection {

    public TurnMarket() {
    }

    @Override
    public final void process() {
        while (!(this.getData().getToken().contains("MISCELLANEOUS"))) {
            if (this.getData().getToken().contains("Market units available")) {

                Market market = this.getData().getPersistence().getMarketDAO().load((GameImpl) this.getData().getActiveGame(), (TurnNumberImpl) this.getData().getActiveNationTurn().getTurnNumber());
                
                if (market.getResourceDetails() == null) {
                    ResourceDetails details = new ResourceDetailsImpl();
                    details.setTurnNumber((TurnNumberImpl)this.getData().getActiveNationTurn().getTurnNumber());
                    details.setLeatherStore(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
                    details.setBronzeStore(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
                    details.setSteelStore(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
                    details.setMithrilStore(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
                    details.setFoodStore(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
                    details.setTimberStore(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
                    details.setMountsStore(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
                    this.getData().getPersistence().getResourceDetailsDAO().save(details);
                    this.getData().nextToken();

                    MarketPrices prices = new MarketPricesImpl();
                    details.setMarketPrices((MarketPricesImpl)prices);
                    prices.setLeatherBuyPrice(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
                    prices.setBronzeBuyPrice(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
                    prices.setSteelBuyPrice(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
                    prices.setMithrilBuyPrice(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
                    prices.setFoodBuyPrice(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
                    prices.setTimberBuyPrice(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
                    prices.setMountsBuyPrice(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
                    this.getData().nextToken();
                    prices.setLeatherSellPrice(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
                    prices.setBronzeSellPrice(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
                    prices.setSteelSellPrice(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
                    prices.setMithrilSellPrice(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
                    prices.setFoodSellPrice(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
                    prices.setTimberSellPrice(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
                    prices.setMountsSellPrice(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
                    this.getData().getPersistence().getMarketPricesDAO().save(prices);

                    market.setResourceDetails(details);
                    market.setMarketPrices(prices);

                    this.getData().getPersistence().getMarketDAO().save(market);
                }
            }
            this.getData().nextToken();
        }

    }
}
