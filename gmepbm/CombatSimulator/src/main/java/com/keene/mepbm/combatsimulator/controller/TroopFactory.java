/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keene.mepbm.combatsimulator.controller;

import com.keene.mepbm.combatsimulator.constants.BaseTroopStats;
import com.keene.mepbm.combatsimulator.troops.Armor;
import com.keene.mepbm.combatsimulator.troops.Training;
import com.keene.mepbm.combatsimulator.troops.Troops;
import com.keene.mepbm.combatsimulator.troops.Weapons;
import org.apache.log4j.Logger;

/**
 *
 * @author Galen
 */
public class TroopFactory {

    private static Logger log = Logger.getLogger(TroopFactory.class);

    public static Troops createTroop(int numberOfTroops, BaseTroopStats type, Training trainingValue, Weapons weaponValue, Armor armorClass) {
        Troops myTroops = new Troops(numberOfTroops, type, trainingValue, weaponValue, armorClass);
        log.info("Base Troop Strength : " + myTroops.getMyCombat().getBaseTroopStrength());
        log.info("Base Troop Strength : " + myTroops.getMyCombat().getBaseTroopConstitution());
        return myTroops;
        
    }
}
