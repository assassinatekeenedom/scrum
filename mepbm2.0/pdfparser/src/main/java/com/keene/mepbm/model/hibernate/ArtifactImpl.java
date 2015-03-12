package com.keene.mepbm.model.hibernate;

import com.keene.hibernate.dao.HibernateModel;
import com.keene.mepbm.model.Artifact;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
//@Table(name="Artifact")
public class ArtifactImpl implements Serializable, Artifact<AllegianceImpl, GameImpl, CharacterImpl,NationTurnImpl,TurnNumberImpl>, HibernateModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int artifactId;
    @Column
    private String type;
    @Column
    private int number;
    @Column
    private int mageSkill;
    @Column
    private int agentSkill;
    @Column
    private int emissarySkill;
    @Column
    private int commandSkill;
    @Column
    private int stealth;
    @Column
    private String knownPowers;
    @Column
    private int combatDamage;
    @Column
    private String name;
    @Column
    private String location;
    @Column
    private boolean hidden;
    @Column
    private String latent;
    @OneToOne()
    private GameImpl game;
    @OneToOne()
    private AllegianceImpl alignment;
    @OneToOne
    private NationTurnImpl nationTurn;
    @OneToOne
    private CharacterImpl owner;
    @OneToOne
    private TurnNumberImpl turnNumber;

    public ArtifactImpl() {
    }

    @Override
    public int getAgentSkill() {
        return agentSkill;
    }

    @Override
    public void setAgentSkill(int agentSkill) {
        this.agentSkill = agentSkill;
    }

    @Override
    public AllegianceImpl getAlignment() {
        return alignment;
    }

    @Override
    public void setAlignment(AllegianceImpl alignment) {
        this.alignment = alignment;
    }

    @Override
    public int getArtifactId() {
        return artifactId;
    }

    @Override
    public void setArtifactId(int artifactId) {
        this.artifactId = artifactId;
    }

    @Override
    public int getCombatDamage() {
        return combatDamage;
    }

    @Override
    public void setCombatDamage(int combatDamage) {
        this.combatDamage = combatDamage;
    }

    @Override
    public int getCommandSkill() {
        return commandSkill;
    }

    @Override
    public void setCommandSkill(int commandSkill) {
        this.commandSkill = commandSkill;
    }

    @Override
    public int getEmissarySkill() {
        return emissarySkill;
    }

    @Override
    public void setEmissarySkill(int emissarySkill) {
        this.emissarySkill = emissarySkill;
    }

    @Override
    public String getKnownPowers() {
        return knownPowers;
    }

    @Override
    public void setKnownPowers(String knownPowers) {
        this.knownPowers = knownPowers;
    }

    @Override
    public int getMageSkill() {
        return mageSkill;
    }

    @Override
    public void setMageSkill(int mageSkill) {
        this.mageSkill = mageSkill;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public int getStealth() {
        return stealth;
    }

    @Override
    public void setStealth(int stealth) {
        this.stealth = stealth;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public GameImpl getGame() {
        return game;
    }

    @Override
    public void setGame(GameImpl game) {
        this.game = game;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean isHidden() {
        return hidden;
    }

    @Override
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    @Override
    public String getLatent() {
        return latent;
    }

    @Override
    public void setLatent(String latent) {
        this.latent = latent;
    }

    @Override
    public CharacterImpl getOwner() {
        return owner;
    }

    @Override
    public void setOwner(CharacterImpl owner) {
        this.owner = owner;
    }

    @Override
    public NationTurnImpl getNationTurn() {
        return nationTurn;
    }

    @Override
    public void setNationTurn(NationTurnImpl nationTurn) {
        this.nationTurn = nationTurn;
    }

    @Override
    public TurnNumberImpl getTurnNumber() {
        return turnNumber;
    }

    @Override
    public void setTurnNumber(TurnNumberImpl turnNumber) {
        this.turnNumber = turnNumber;
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        toString.append("\tARTIFACT INFO: ");
        toString.append(" (id=");
        toString.append(this.getArtifactId());
        toString.append(")\n");
        toString.append("\t\tName: ");
        toString.append(this.getName());
        toString.append("\n");
        toString.append("\t\tNumber: ");
        toString.append(this.getNumber());
        toString.append("\n");
        if (this.getAlignment() != null) {
            toString.append(this.getAlignment());
        }
        toString.append("\t\tKnown Powers: ");
        toString.append(this.getKnownPowers());
        toString.append("\n");
        toString.append("\t\tCombat Damage: ");
        toString.append(this.getCombatDamage());
        toString.append("\n");
        toString.append("\t\tAgent Skill: ");
        toString.append(this.getAgentSkill());
        toString.append("\n");
        toString.append("\t\tMage Skill: ");
        toString.append(this.getMageSkill());
        toString.append("\n");
        toString.append("\t\tCommand Skill: ");
        toString.append(this.getCommandSkill());
        toString.append("\n");
        toString.append("\t\tEmissary Skill: ");
        toString.append(this.getEmissarySkill());
        toString.append("\n");
        toString.append("\t\tStealth: ");
        toString.append(this.getStealth());
        toString.append("\n");
        toString.append("\t\tHidden: ");
        toString.append(this.isHidden());
        toString.append("\n");
        toString.append("\t\tlatent: ");
        toString.append(this.getLatent());
        toString.append("\n");
        return toString.toString();
    }
}
