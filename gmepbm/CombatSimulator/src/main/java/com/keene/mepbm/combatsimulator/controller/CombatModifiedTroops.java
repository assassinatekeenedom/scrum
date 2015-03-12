/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keene.mepbm.combatsimulator.controller;

import com.keene.mepbm.combatsimulator.army.Army;
import com.keene.mepbm.combatsimulator.constants.TacticPerformance;
import com.keene.mepbm.combatsimulator.constants.Tactics;
import com.keene.mepbm.combatsimulator.constants.TerrainPerformance;
import com.keene.mepbm.combatsimulator.constants.Terrain;
import com.keene.mepbm.combatsimulator.troops.Troops;
import org.apache.log4j.Logger;

/**
 *
 * @author Galen
 */
public class CombatModifiedTroops {

    private static Logger log = Logger.getLogger(TroopFactory.class);

    public static int caculateTroopStrength(Army myArmy, Terrain terrain, Tactics tactic) {
        int troopStrength = 0;
        for (Troops troops : myArmy) {
            double interim = troops.getTrainingValue().getTrainingRank() + troops.getWeaponValue().getWeaponRank() + ((TerrainPerformance) (troops.getTroopType().getCombatPerformanceValue().get(terrain))).getValue() + ((TacticPerformance) (troops.getTroopType().getTacticPerformanceValue().get(tactic))).getValue();
            interim = interim / 400;
            log.info("Average Troop Modifier : " + interim);
            troopStrength += (interim * troops.getMyCombat().getBaseTroopStrength());
        }
        log.info("Troop Strength : " + troopStrength);
        return troopStrength;
    }
}
