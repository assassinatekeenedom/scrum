package com.keene.mepbm.reader.pdf.section;

import com.keene.mepbm.model.Nation;
import com.keene.mepbm.model.NationRelation;
import com.keene.mepbm.model.Relation;
import com.keene.mepbm.model.hibernate.NationRelationImpl;

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

                Nation nationDest = this.getData().getPersistence().getNationDAO().load(name, this.getData().getActiveGame());
                nationDest.setNumber(number);

                token = this.getData().nextToken();

                Relation relation = this.getData().getPersistence().getRelationDAO().load(token.substring(3, token.length()));

                nationRelation.setDestination(nationDest);
                nationRelation.setSource(this.getData().getActiveNation());
                nationRelation.setRelation(relation);
                nationRelation.setTurnNumber(this.getData().getActiveNationTurn().getTurnNumber());
                nationRelation.setNationTurn(this.getData().getActiveNationTurn());
                this.getData().getPersistence().getNationRelationDAO().save(nationRelation);
            }
        }
        this.getData().nextToken();
    }
}
