package com.keene.mepbm.models.impl;

import com.keene.mepbm.models.Spell;
import com.keene.mepbm.models.Character;

public class SpellImpl implements Spell<Character> {

    private int spellId;
    private int number;
    private String name;
    private int orderNumber;
    private int proficiency;
    private Character character;

    public SpellImpl() {
    }

    @Override
    public int getSpellId() {
        return spellId;
    }

    @Override
    public void setSpellId(int spellId) {
        this.spellId = spellId;
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
    public int getNumber() {
        return number;
    }

    @Override
    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public int getOrderNumber() {
        return orderNumber;
    }

    @Override
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public int getProficiency() {
        return proficiency;
    }

    @Override
    public void setProficiency(int proficiency) {
        this.proficiency = proficiency;
    }

    @Override
    public Character getCharacter() {
        return character;
    }

    @Override
    public void setCharacter(Character character) {
        this.character = character;
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        toString.append("\tSPELL INFO: ");
        toString.append(" (id=");
        toString.append(this.getSpellId());
        toString.append(")\n");
        toString.append("\t\tNumber: ");
        toString.append(this.getNumber());
        toString.append("\n");
        toString.append("\t\tName: ");
        toString.append(this.getName());
        toString.append("\n");
        toString.append("\t\tProficiency: ");
        toString.append(this.getProficiency());
        toString.append("\n");
        toString.append("\t\tOrder Number: ");
        toString.append(this.getOrderNumber());
        toString.append("\n");
        return toString.toString();
    }
}
