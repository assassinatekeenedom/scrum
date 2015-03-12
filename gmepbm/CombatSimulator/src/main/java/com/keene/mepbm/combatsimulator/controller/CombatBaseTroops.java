/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.keene.mepbm.combatsimulator.controller;

import com.keene.mepbm.combatsimulator.troops.Troops;

/**
 *
 * @author Galen
 */
public class CombatBaseTroops {

    private int baseTroopStrength;
    private int baseTroopConstitution;
    
    public CombatBaseTroops() {
    
    }
    
    public void calculateBaseTroopStrength(Troops myTroops) {
        baseTroopStrength = myTroops.getNumberOfTroops() * myTroops.getTroopType().getStrength();        
    }
    
    public void calculateBaseTroopConstitution(Troops myTroops) {
        baseTroopConstitution = myTroops.getNumberOfTroops() * myTroops.getTroopType().getConstitution();
    }

    public int getBaseTroopConstitution() {
        return baseTroopConstitution;
    }

    public void setBaseTroopConstitution(int baseTroopConstitution) {
        this.baseTroopConstitution = baseTroopConstitution;
    }

    public int getBaseTroopStrength() {
        return baseTroopStrength;
    }

    public void setBaseTroopStrength(int baseTroopStrength) {
        this.baseTroopStrength = baseTroopStrength;
    }
    
}
