package com.keene.mepbm.models;

public interface Artifact<A extends Allegiance, G extends Game, C extends Character, N extends NationTurn, T extends TurnNumber> {

    public int getAgentSkill();

    public void setAgentSkill(int agentSkill);

    public A getAlignment();

    public void setAlignment(A alignment);

    public int getArtifactId();

    public void setArtifactId(int artifactId);

    public int getCombatDamage();

    public void setCombatDamage(int combatDamage);

    public int getCommandSkill();

    public void setCommandSkill(int commandSkill);

    public int getEmissarySkill();

    public void setEmissarySkill(int emissarySkill);

    public String getKnownPowers();

    public void setKnownPowers(String knownPowers);

    public int getMageSkill();

    public void setMageSkill(int mageSkill);

    public int getNumber();

    public void setNumber(int number);

    public int getStealth();

    public void setStealth(int stealth);

    public String getType();

    public void setType(String type);

    public String getName();

    public void setName(String name);

    public G getGame();

    public void setGame(G game);

    public String getLocation();

    public void setLocation(String location);

    public boolean isHidden();

    public void setHidden(boolean hidden);

    public String getLatent();

    public void setLatent(String latent);

    public C getOwner();

    public void setOwner(C owner);

    public N getNationTurn();

    public void setNationTurn(N nationTurn);

    public T getTurnNumber();

    public void setTurnNumber(T turnNumber);
}
