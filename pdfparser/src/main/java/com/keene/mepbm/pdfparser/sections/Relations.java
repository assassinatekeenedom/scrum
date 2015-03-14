package com.keene.mepbm.pdfparser.sections;

import com.keene.mepbm.models.Nation;
import com.keene.mepbm.models.NationRelation;
import com.keene.mepbm.models.Relation;
import com.keene.mepbm.models.impl.NationRelationImpl;

public final class Relations extends TurnPDFSection {

    public Relations() {
    }

    @Override
    public final void process() {
        while (!this.getData().getToken().contains("POPULATION CENTERS")) {
            String token = this.getData().nextToken();
            NationRelation nationRelation = new NationRelationImpl();
            if (token.contains("#")) {
                int number = -1;
                if (token.contains("# ")) {
                    number = Integer.parseInt(token.substring((token.indexOf("# ") + 2), token.indexOf(" ", 3)));
                } else if (token.contains("#")) {
                    number = Integer.parseInt(token.substring((token.indexOf("#") + 1), token.indexOf(" ", 3)));
                }
                String name = token.substring((token.indexOf(" ", 3) + 1), token.length());

//                Nation nationDest = this.getData().getPersistence().getNationDAO().load(name, this.getData().getActiveGame());
//                nationDest.setNumber(number);

                token = this.getData().nextToken();

//                Relation relation = this.getData().getPersistence().getRelationDAO().load(token.substring(3, token.length()));

//                nationRelation.setDestination(nationDest);
                nationRelation.setSource(this.getData().getActiveNation());
//                nationRelation.setRelation(relation);
                nationRelation.setTurnNumber(this.getData().getActiveNationTurn().getTurnNumber());
                nationRelation.setNationTurn(this.getData().getActiveNationTurn());                
            }
        }
        this.getData().nextToken();
    }
}
