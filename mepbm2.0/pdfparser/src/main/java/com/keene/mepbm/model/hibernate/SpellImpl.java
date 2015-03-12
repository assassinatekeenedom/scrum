package com.keene.mepbm.model.hibernate;

import com.keene.hibernate.dao.HibernateModel;
import com.keene.mepbm.model.Spell;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
//@Table(name="Spell")
public class SpellImpl implements Serializable, Spell<CharacterImpl>, HibernateModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int spellId;
    @Column
    private int number;
    @Column
    private String name;
    @Column
    private int orderNumber;
    @Column
    private int proficiency;
    @OneToOne
    private CharacterImpl character;

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
    public CharacterImpl getCharacter() {
        return character;
    }

    @Override
    public void setCharacter(CharacterImpl character) {
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
