package com.keene.mepbm.pdfparser.sections;

import com.keene.mepbm.models.impl.ArmyImpl;
import com.keene.mepbm.models.impl.CharacterImpl;
import com.keene.mepbm.models.impl.HexImpl;
import com.keene.mepbm.models.impl.NationImpl;
import com.keene.mepbm.models.impl.NationTurnImpl;
import com.keene.mepbm.models.impl.PopulationCenterImpl;
import com.keene.mepbm.models.impl.ResourceDetailsImpl;
import com.keene.mepbm.models.impl.TurnNumberImpl;

public final class PopCenters extends TurnPDFSection {

    public PopCenters() {
    }

    @Override
    public final void process() {
        String token = null;
        while ((token = this.getData().getToken()) != null) {
            if (token.contains("ARMIES AND NAVIES")) {
                break;
            }
            this.nextPopulationCenter();
        }
        this.getData().nextToken();
    }

    private void nextPopulationCenter() {
        PopulationCenterImpl popCenter = new PopulationCenterImpl();
        popCenter.setTurnNumber((TurnNumberImpl) this.getData().getActiveNationTurn().getTurnNumber());        
        String token = this.getData().getToken();
        popCenter.setName(token);
        token = this.getData().nextToken();
        if (token.contains("(")) {
            popCenter.setCapital(true);
            token = this.getData().nextToken();
        }
        if (token.contains("    Location : @")) {
            popCenter.setHex((HexImpl) this.getData().parseLocation());
        }
        token = this.getData().nextToken();
        popCenter.setSize(token.substring("Size : ".length(), token.length()));

        token = this.getData().nextToken();
        popCenter.setFortification(token.substring("Fortifications : ".length(), token.length()));

        token = this.getData().nextToken();
        popCenter.setLoyalty(Integer.parseInt(token.substring("Loyalty : ".length(), token.length())));

        token = this.getData().nextToken();
        popCenter.setDocks(token.substring("Docks : ".length(), token.length()));

        token = this.getData().nextToken();
        if (token.substring("Hidden ? : ".length(), token.length()).equals("No")) {
            popCenter.setHidden(false);
        } else {
            popCenter.setHidden(true);
        }

        token = this.getData().nextToken();
        if (token.substring("Sieged ? : ".length(), token.length()).equals("No")) {
            popCenter.setSieged(false);
        } else {
            popCenter.setSieged(true);
        }

        token = this.getData().nextToken();
        token = this.getData().nextToken();
        token = token.substring("Expected production".length(), token.length());
        boolean moreResources = true;
        int count = 0;
        ResourceDetailsImpl detailsImpl = new ResourceDetailsImpl();
        detailsImpl.setPopulationCenter(popCenter);
        detailsImpl.setTurnNumber((TurnNumberImpl)this.getData().getActiveNationTurn().getTurnNumber());
        detailsImpl.setNation((NationImpl)this.getData().getActiveNation());
        while (moreResources) {
            while (token.indexOf(" ") == 0) {
                token = token.substring(1, token.length());
            }
            int productionValue = 0;
            if (count < 7) {
                productionValue = Integer.parseInt(token.substring(0, token.indexOf(" ")));
            } else if (!(token.indexOf("-") > 0)) {
                productionValue = Integer.parseInt(token.substring(0, token.length()));
            }
            switch (count) {
                case 0:
                    detailsImpl.setLeatherProduction(productionValue);
                    break;
                case 1:
                    detailsImpl.setBronzeProduction(productionValue);
                    break;
                case 2:
                    detailsImpl.setSteelProduction(productionValue);
                    break;
                case 3:
                    detailsImpl.setMithrilProduction(productionValue);
                    break;
                case 4:
                    detailsImpl.setFoodProduction(productionValue);
                    break;
                case 5:
                    detailsImpl.setTimberProduction(productionValue);
                    break;
                case 6:
                    detailsImpl.setMountsProduction(productionValue);
                    break;
                case 7:
                    if (token.contains("-")) {
                        detailsImpl.setGoldProduction(0);
                    } else {
                        detailsImpl.setGoldProduction(productionValue);
                    }
                    moreResources = false;
                    break;
                default:
                    break;
            }
            if (moreResources) {
                token = token.substring(token.indexOf(" "), token.length());
                count++;
            }
        }
        token = this.getData().nextToken();
        token = token.substring("Current stores".length(), token.length());
        moreResources = true;
        count = 0;
        while (moreResources) {
            while (token.indexOf(" ") == 0) {
                token = token.substring(1, token.length());
            }
            int productionValue = 0;
            if (count < 7) {
                productionValue = Integer.parseInt(token.substring(0, token.indexOf(" ")));
            } else if (!(token.contains("-"))) {
                productionValue = Integer.parseInt(token);
            }
            switch (count) {
                case 0:
                    detailsImpl.setLeatherStore(productionValue);
                    break;
                case 1:
                    detailsImpl.setBronzeStore(productionValue);
                    break;
                case 2:
                    detailsImpl.setSteelStore(productionValue);
                    break;
                case 3:
                    detailsImpl.setMithrilStore(productionValue);
                    break;
                case 4:
                    detailsImpl.setFoodStore(productionValue);
                    break;
                case 5:
                    detailsImpl.setTimberStore(productionValue);
                    break;
                case 6:
                    detailsImpl.setMountsStore(productionValue);
                    break;
                case 7:
                    if (token.contains("-")) {
                        detailsImpl.setGoldStore(0);
                    } else {
                        detailsImpl.setGoldStore(productionValue);
                    }
                    moreResources = false;
                    break;
            }
            if (moreResources) {
                token = token.substring(token.indexOf(" "), token.length());
                count++;
            }
        }        
        popCenter.setNationTurn((NationTurnImpl)this.getData().getActiveNationTurn());
        token = this.getData().nextToken();
        if (token.contains("Foreign characters reported")) {
            while (!(token.contains("."))) {
                token = this.getData().nextToken();
//                CharacterImpl character = (CharacterImpl) this.getData().getPersistence().getCharacterDAO().load(token, this.getData().getActiveGame(), this.getData().getActiveNationTurn().getTurnNumber());
//                character.setPopulationCenter(popCenter);
            }
            token = this.getData().nextToken();
        }
        while (token.contains("army") || token.contains("navy")) {
            if (token.contains("under ")) {
                token = token.substring(token.indexOf("under ") + 6, token.length());
                token = token.substring(token.indexOf(" ") + 1, token.length());
                token = token.substring(0, token.indexOf(" "));
//                CharacterImpl character = (CharacterImpl) this.getData().getPersistence().getCharacterDAO().load(token, this.getData().getActiveGame(), this.getData().getActiveNationTurn().getTurnNumber());
//                ArmyImpl army = (ArmyImpl) this.getData().getPersistence().getArmyDAO().load(character, this.getData().getActiveNationTurn().getTurnNumber());
//                army.setPopulationCenter(popCenter);
//                this.getData().getPersistence().getArmyDAO().save(army);
            }
            token = this.getData().nextToken();
        }
        if (token.contains(".")) {
            token = this.getData().nextToken();
        }
        
    }
}
