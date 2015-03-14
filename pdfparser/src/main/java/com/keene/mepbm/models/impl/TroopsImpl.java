package com.keene.mepbm.models.impl;

import com.keene.mepbm.models.Army;
import com.keene.mepbm.models.Troops;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class TroopsImpl implements Troops<Army> {

    @Id
    @GeneratedValue
    @Column(unique = true)
    private int troopsId;
    @Column()
    private int numbers;
    @Column()
    private int training;
    @Column()
    private int weapons;
    @Column()
    private int armor;
    @Column()
    private String troopType;
    @Column()
    private String description;
    @OneToOne
    private ArmyImpl army;

    public TroopsImpl() {
    }

    @Override
    public int getArmor() {
        return armor;
    }

    @Override
    public void setArmor(int armor) {
        this.armor = armor;
    }

    @Override
    public int getTroopsId() {
        return troopsId;
    }

    @Override
    public void setTroopsId(int troopsId) {
        this.troopsId = troopsId;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int getNumbers() {
        return numbers;
    }

    @Override
    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    @Override
    public int getTraining() {
        return training;
    }

    @Override
    public void setTraining(int training) {
        this.training = training;
    }

    @Override
    public String getTroopType() {
        return troopType;
    }

    @Override
    public void setTroopType(String troopType) {
        this.troopType = troopType;
    }

    @Override
    public int getWeapons() {
        return weapons;
    }

    @Override
    public void setWeapons(int weapons) {
        this.weapons = weapons;
    }

    @Override
    public Army getArmy() {
        return army;
    }

    @Override
    public void setArmy(Army army) {
        this.army = (ArmyImpl) army;
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        toString.append("\tTROOPS INFO:");
        toString.append(" (id=");
        toString.append(this.getTroopsId());
        toString.append(")\n");
        toString.append("\t\tTroop Number: ");
        toString.append(this.getNumbers());
        toString.append("\n");
        toString.append("\t\tTroop Type: ");
        toString.append(this.getTroopType());
        toString.append("\n");
        toString.append("\t\tDescription: ");
        toString.append(this.getDescription());
        toString.append("\n");
        toString.append("\t\tTraining: ");
        toString.append(this.getTraining());
        toString.append("\n");
        toString.append("\t\tWeapons: ");
        toString.append(this.getWeapons());
        toString.append("\n");
        toString.append("\t\tArmor: ");
        toString.append(this.getArmor());
        toString.append("\n");
        return toString.toString();
    }
}
