package com.keene.mepbm.reader.pdf.section;

import com.keene.mepbm.model.Message;
import com.keene.mepbm.model.hibernate.MessageImpl;
import com.keene.mepbm.model.hibernate.MessageTypes;

public final class Messages extends TurnPDFSection {

    public Messages() {
    }

    @Override
    public final void process() {
        this.processNationMessages();
        this.processEncounterMessages();
        this.processCombatMessages();
        this.processSpecialMessages();
    }

    private void processNationMessages() {
        while (!this.getData().getToken().contains("ENCOUNTER MESSAGES")) {
            if (!this.getData().getToken().contains("None")) {
                Message message = new MessageImpl();
                message.setMessage(this.getData().getToken());
                message.setGame(this.getData().getActiveGame());
                message.setType(MessageTypes.NATION.getType());
                message.setNationTurn(this.getData().getActiveNationTurn());
                message.setTurnNumber(this.getData().getActiveNationTurn().getTurnNumber());
                this.getData().getPersistence().getMessageDAO().save(message);
            }
            this.getData().nextToken();
        }
    }

    private void processEncounterMessages() {
        if (this.getData().getToken().contains("ENCOUNTER MESSAGE")) {
            this.getData().nextToken();
            StringBuilder encounterMessage = new StringBuilder();
            while (!this.getData().getToken().contains("COMBAT MESSAGES")) {
                encounterMessage.append(this.getData().getToken());
                this.getData().nextToken();
            }
            if (!encounterMessage.toString().contains("None")) {
                Message message = new MessageImpl();
                message.setMessage(encounterMessage.toString());
                message.setGame(this.getData().getActiveGame());
                message.setType(MessageTypes.ENCOUNTER.getType());
                message.setNationTurn(this.getData().getActiveNationTurn());
                message.setTurnNumber(this.getData().getActiveNationTurn().getTurnNumber());
                this.getData().getPersistence().getMessageDAO().save(message);
            }
        }
    }

    private void processCombatMessages() {
        if (this.getData().getToken().contains("COMBAT MESSAGE")) {
            this.getData().nextToken();
            if (this.getData().getToken().trim().length() != 0) {
                StringBuilder combatMessage = new StringBuilder();
                while (!this.getData().getToken().contains("SPECIAL MESSAGES") && !this.getData().getToken().contains("FREE TURNS")) {
                    combatMessage.append(this.getData().getToken());
                    this.getData().nextToken();
                }
                if (!combatMessage.toString().contains("None")) {
                    Message message = new MessageImpl();
                    message.setMessage(combatMessage.toString());
                    message.setGame(this.getData().getActiveGame());
                    message.setType(MessageTypes.COMBAT.getType());
                    message.setNationTurn(this.getData().getActiveNationTurn());
                    message.setTurnNumber(this.getData().getActiveNationTurn().getTurnNumber());
                    this.getData().getPersistence().getMessageDAO().save(message);
                }
            }
        }
    }

    private void processSpecialMessages() {
        if (this.getData().getToken().contains("SPECIAL MESSAGE") || this.getData().getToken().contains("FREE TURNS")) {
            this.getData().nextToken();
            StringBuilder specialMessage = new StringBuilder();
            while (!this.getData().getToken().contains("ORDERS GIVEN")) {
                specialMessage.append(this.getData().getToken());
                this.getData().nextToken();
            }
            if (!specialMessage.toString().contains("None")) {
                Message message = new MessageImpl();
                message.setMessage(specialMessage.toString());
                message.setGame(this.getData().getActiveGame());
                message.setType(MessageTypes.SPECIAL.getType());
                message.setNationTurn(this.getData().getActiveNationTurn());
                message.setTurnNumber(this.getData().getActiveNationTurn().getTurnNumber());
                this.getData().getPersistence().getMessageDAO().save(message);
            }
        }
    }
}
