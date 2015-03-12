package com.keene.mepbm.reader.xml.section;

import com.keene.mepbm.model.Artifact;
import com.keene.mepbm.model.Climate;
import com.keene.mepbm.model.Hex;
import com.keene.mepbm.model.Character;
import com.keene.mepbm.model.Spell;
import com.keene.mepbm.model.Terrain;
import com.keene.mepbm.model.hibernate.SpellImpl;
import java.util.Set;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public final class Characters extends TurnXMLSection {

    public Characters() {
    }

    @Override
    public final void process() {
        Set<Element> elements = this.getData().getElements("Character");
        for (Element element : elements) {
            String name = this.getData().getTextValue(element, "Name");
            name = this.getData().getPdfData().removeSpecialCharacters(name);
            Character character = this.getData().getPersistence().getCharacterDAO().load(name, this.getData().getPdfData().getActiveGame(), this.getData().getPdfData().getActiveNationTurn().getTurnNumber());
            if (!(this.getData().getTextValue(element, "Location").equals("HOST"))) {
                Climate climate = this.getData().getPersistence().getClimateDAO().load("unknown");
                Terrain terrain = this.getData().getPersistence().getTerrainDAO().load("unknown");
                Hex hex = this.getData().getPersistence().getHexDAO().load(this.getData().getIntValue(element, "Location"), climate, terrain);
                character.setHex(hex);
            } else {
                character.setKidnapped(true);
            }
            character.setCommandRank(this.getData().getIntValue(element, "Command"));
            character.setAgentRank(this.getData().getIntValue(element, "Agent"));
            character.setEmissaryRank(this.getData().getIntValue(element, "Emmisary"));
            character.setMageRank(this.getData().getIntValue(element, "Mage"));
            character.setStealth(this.getData().getIntValue(element, "Stealth"));
            character.setTotalCommandRank(this.getData().getIntValue(element, "TotalCommand"));
            character.setTotalAgentRank(this.getData().getIntValue(element, "TotalAgent"));
            character.setTotalEmissaryRank(this.getData().getIntValue(element, "TotalEmmisary"));
            character.setTotalMageRank(this.getData().getIntValue(element, "TotalMage"));
            character.setStealth(this.getData().getIntValue(element, "TotalStealth"));
            character.setChallengeRank(this.getData().getIntValue(element, "Challenge"));
            character.setHealth(this.getData().getIntValue(element, "Health"));
            character.setNationTurn(this.getData().getPdfData().getActiveNationTurn());

            this.getData().getPersistence().getCharacterDAO().save(character);

            NodeList artifacts = this.getData().getElements(element, "Artifacts");
            if (artifacts != null && artifacts.getLength() > 0) {
                Element artifactElement = (Element) artifacts.item(0);
                NodeList artifactList = artifactElement.getChildNodes();
                for (int x = 0; x < artifactList.getLength(); x++) {
                    int artifactNumber = this.parseArtifact((Node) artifactList.item(x));
                    if (artifactNumber > 0) {
                        Artifact artifact = this.getData().getPersistence().getArtifactDAO().load(artifactNumber, this.getData().getPdfData().getActiveGame(), this.getData().getPdfData().getActiveNationTurn().getTurnNumber());
                        artifact.setOwner(character);
                        this.getData().getPersistence().getArtifactDAO().save(artifact);
                    }
                }
            }

            NodeList spells = this.getData().getElements(element, "Spells");
            if (spells != null && spells.getLength() > 0) {
                Element spellsElement = (Element) spells.item(0);
                NodeList spellList = spellsElement.getChildNodes();
                for (int x = 0; x < spellList.getLength(); x++) {
                    Spell spell = this.parseSpell((Element) spellList.item(x));
                    spell.setCharacter(character);
                    this.getData().getPersistence().getSpellDAO().save(spell);
                }
            }

        }
    }

    private Spell parseSpell(Element spellElement) {
        String token = spellElement.getTextContent();
        String spellNumber = token.substring(token.indexOf("#") + 1, token.indexOf(" ", token.indexOf("#")));
        String spellName = token.substring(token.indexOf(" ") + 1, token.indexOf("("));
        String proficiency = token.substring(token.indexOf("(") + 1, token.indexOf(")"));
        Spell spell = new SpellImpl();
        spell.setNumber(Integer.parseInt(spellNumber));
        spell.setName(spellName);
        spell.setProficiency(Integer.parseInt(proficiency));

        return spell;
    }

    private int parseArtifact(Node artifact) {
        if (artifact.getNodeType() == Node.ELEMENT_NODE) {
            return this.parseArtifact((Element) artifact);
        }
        return -1;
    }

    private int parseArtifact(Element artifactElement) {
        String token = artifactElement.getTextContent();
        return Integer.parseInt(token.substring(token.indexOf("#") + 1, token.indexOf(" ")));
    }
}
