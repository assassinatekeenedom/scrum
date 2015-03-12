/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.keene.mepbm.combatsimulator.troops;

import com.keene.mepbm.combatsimulator.constants.BaseTroopStats;
import com.keene.mepbm.combatsimulator.controller.CombatBaseTroops;

/**
 *
 * @author Galen
 */
public class Troops {
    
    private int numberOfTroops;
    private BaseTroopStats troopType;
    private Armor armorClass;
    private Weapons weaponValue;
    private Training trainingValue;
    private CombatBaseTroops myCombat;


    public Troops(int numberOfTroops, BaseTroopStats troopType, Training trainingValue, Weapons weaponValue, Armor armorClass) {
        this.numberOfTroops = numberOfTroops;
        this.troopType = troopType;
        this.armorClass = armorClass;
        this.weaponValue = weaponValue;
        this.trainingValue = trainingValue;
        this.myCombat = new CombatBaseTroops();
        myCombat.calculateBaseTroopStrength(this);
        myCombat.calculateBaseTroopConstitution(this);
    }

    public int getNumberOfTroops() {
        return numberOfTroops;
    }

    public void setNumberOfTroops(int numberOfTroops) {
        this.numberOfTroops = numberOfTroops;
    }

    public BaseTroopStats getTroopType() {
        return troopType;
    }

    public void setTroopType(BaseTroopStats troopType) {
        this.troopType = troopType;
    }

    public Armor getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(Armor armorClass) {
        this.armorClass = armorClass;
    }

    public Weapons getWeaponValue() {
        return weaponValue;
    }

    public void setWeaponValue(Weapons weaponValue) {
        this.weaponValue = weaponValue;
    }

    public Training getTrainingValue() {
        return trainingValue;
    }

    public void setTrainingValue(Training trainingValue) {
        this.trainingValue = trainingValue;
    }

    public CombatBaseTroops getMyCombat() {
        return myCombat;
    }

    public void setMyCombat(CombatBaseTroops myCombat) {
        this.myCombat = myCombat;
    }

}
