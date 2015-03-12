package com.keene.mepbm.reader.pdf.section;

import com.keene.mepbm.model.Army;
import com.keene.mepbm.model.hibernate.ArmyImpl;
import com.keene.mepbm.model.Character;
import com.keene.mepbm.model.hibernate.CharacterImpl;
import com.keene.mepbm.model.hibernate.HexImpl;
import com.keene.mepbm.model.hibernate.TroopsImpl;

public final class ArmiesAndNavies extends TurnPDFSection{

    public ArmiesAndNavies() {
    }

    @Override
    public final void process() {
        String token = null;
        while ((token = this.getData().getToken()) != null) {
            if (token.contains("COMPANY COMMANDERS :")) {
                break;
            }
            this.parseArmy();
        }
    }

    private void parseArmy() {
        String token = this.getData().getToken();
        if (!("None").equals(token)) {
            token = this.getData().isolateRightColumnString(token, "Army Commander : ");
            token = token.substring(token.indexOf(" ") + 1, token.length());
            this.getData().nextToken();
            CharacterImpl commander = (CharacterImpl) this.getData().getPersistence().getCharacterDAO().load(token.toLowerCase(), this.getData().getActiveGame(), this.getData().getActiveNationTurn().getTurnNumber());
            Army army = this.getData().getPersistence().getArmyDAO().load(commander, this.getData().getActiveNationTurn().getTurnNumber());
            army.setHex((HexImpl)this.getData().parseLocation());
            token = this.getData().nextToken();

            String morale = token.substring(0, token.indexOf("  Warships :"));
            String warships = token.substring(token.indexOf("Warships :"), token.indexOf("  Transports  :"));
            String transports = token.substring(token.indexOf("Transports  :"), token.indexOf("  ("));
            String travelMode = token.substring(token.indexOf("Travel mode  :"), token.length());

            army.setArmyCommander(commander);
            army.setMorale(this.getData().isolateRightColumnNumber(morale, "Army morale :"));
            army.setWarships(this.getData().isolateRightColumnNumber(warships, "Warships :"));
            army.setTransports(this.getData().isolateRightColumnNumber(transports, "Transports  :"));
            army.setTravelMode(this.getData().isolateRightColumnString(travelMode, "Travel mode  :"));
            army.setNationTurn(this.getData().getActiveNationTurn());

            this.parseRemainder((ArmyImpl)army);
            this.getData().getPersistence().getArmyDAO().save(army);
        } else {
            token = this.getData().nextToken();
        }
    }

    private void parseRemainder(ArmyImpl army) {
        this.getData().nextToken();
        this.getData().nextToken();
        this.getData().nextToken();

        while (!(this.getData().getToken().contains("Baggage Train"))) {
            this.parseTroops(army);
        }
        this.parseBaggageTrain(army);
    }

    private void parseTroops(ArmyImpl army) {
        TroopsImpl troops = new TroopsImpl();
        troops.setArmy(army);
        troops.setDescription(this.getData().getToken());
        troops.setTraining(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
        troops.setWeapons(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
        troops.setArmor(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
        troops.setNumbers(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
        troops.setTroopType(this.getData().nextToken());
        this.getData().getPersistence().getTroopsDAO().save(troops);
        this.getData().nextToken();
    }

    private void parseBaggageTrain(ArmyImpl army) {
        this.getData().nextToken();
        while (!"Food".equals(this.getData().getToken())) {
            this.getData().nextToken();
        }
        army.setFood(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
        this.getData().nextToken();
        if (this.getData().getToken().contains("Low Supplies") || this.getData().getToken().contains("Out of Food")) {
            this.getData().nextToken();
        }
        if (this.getData().getToken().contains("War machines")) {
            this.getData().nextToken();
            army.setWarMachines(this.getData().isolateRightColumnNumber(this.getData().getToken(), " "));
            this.getData().nextToken();
        }
        if (this.getData().getToken().contains("traveling with army")) {
            while (!(this.getData().getToken().contains("."))) {
                this.parseCharactersWithArmy(this.getData().getToken(), army);
                this.getData().nextToken();
            }
            this.getData().nextToken();
        }
        StringBuilder armyDetails = new StringBuilder();
        while (this.getData().getToken().contains("army bearing") || this.getData().getToken().contains("navy bearing")) {
            armyDetails.append(this.getData().getToken());
            this.getData().nextToken();
        }
        if (this.getData().getToken().indexOf("The") == 0) {
            while (!(this.getData().getToken().contains("Army Commander")) && !(this.getData().getToken().contains("COMPANY COMMANDERS"))) {
                armyDetails.append(this.getData().getToken());
                this.getData().nextToken();
            }
        }
        army.setArmyDetails(armyDetails.toString());
    }

    private void parseCharactersWithArmy(String token, ArmyImpl army) {
        while (token.contains(" - ")) {
            int start = token.indexOf(" - ")+" - ".length();
            int end = token.indexOf(" - ", start);
            if(end < 0){
                end = token.length();
            }
            String name = token.substring(start, end);
            Character character = this.getData().getPersistence().getCharacterDAO().load(name, this.getData().getActiveGame(), this.getData().getActiveNationTurn().getTurnNumber());
            character.setInArmy(army);
            this.getData().getPersistence().getCharacterDAO().save(character);
            token = token.substring(end, token.length());
        }
    }
}
