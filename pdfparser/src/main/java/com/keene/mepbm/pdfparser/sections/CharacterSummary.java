package com.keene.mepbm.pdfparser.sections;

import com.keene.mepbm.models.impl.CharacterImpl;
import java.util.HashMap;
import java.util.Map;

public final class CharacterSummary extends TurnPDFSection {

    public CharacterSummary() {
    }

    @Override
    public final void process() {
        Map<String, String> orderSummaries = this.parseOrderSummaries();
        for (String name : orderSummaries.keySet()) {
            String summary = orderSummaries.get(name);
            if (summary == null) {
                summary = "PDF Parser Error - no Summary Available";
            }
            CharacterImpl character = new CharacterImpl();
            character.setName(name);
            character.setOrderSummary(summary);

            System.out.println(Save.getJSON(Save.set(character)));
//            Character character = this.getData().getPersistence().getCharacterDAO().load(name, this.getData().getActiveGame(), this.getData().getActiveNationTurn().getTurnNumber());
//            character.setOrderSummary(summary);
//            this.getData().getPersistence().getCharacterDAO().save(character);
        }
    }

    private Map<String, String> parseOrderSummaries() {
        Map orderSummaries = new HashMap<String, String>();
        boolean notDone = true;
        while (notDone) {
            StringBuilder orderSummary = new StringBuilder();
            StringBuilder name = new StringBuilder();
            boolean search = true;
            boolean nameR = false;
            while (search) {
                if (!nameR) {
                    while (this.getData().getToken().length() == 1) {
                        try {
                            Integer.parseInt(this.getData().getToken());
                            search = false;
                            notDone = false;
                            return orderSummaries;
                        } catch (Exception e) {
                            name.append(this.getData().getToken());
                            this.getData().nextToken();
                            nameR = true;
                        }
                    }
                }
                if (search) {
                    if ((this.getData().getToken().contains(" was ordered "))
                            || (this.getData().getToken().contains(" commands "))
                            || (this.getData().getToken().contains("was located"))
                            || (this.getData().getToken().contains("is currently"))
                            || (this.getData().getToken().contains("special ability"))) {
                        while (this.getData().getToken().contains(".")) {
                            orderSummary.append(this.getData().removeSpecialCharacters(this.getData().getToken()));
                            this.getData().nextToken();
                            search = false;
                        }
                    } else if (this.getData().getToken().length() > 150) {
                        orderSummary.append("PDF Error -- Missing Summary");
                        this.getData().nextToken();
                        search = false;
                    } else {
                        this.getData().nextToken();
                    }
                }
            }
            if (nameR) {
//                Character character = this.getData().getPersistence().getCharacterDAO().load(name.toString(), this.getData().getActiveGame(), this.getData().getActiveNationTurn().getTurnNumber());
//                orderSummaries.put(character.getName(), orderSummary.toString());
            }
        }
        return orderSummaries;
    }
}
