/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keene.mepbm.combatsimulator.constants;

import java.util.Map;

/**
 *
 * @author Galen
 */
public enum BaseTroopStats {

    HC(16, 16, TroopTerrainCombatPerformance.hcMap, TroopTacticPerformance.hcMap),
    LC(8, 8, TroopTerrainCombatPerformance.lcMap, TroopTacticPerformance.lcMap),
    HI(10, 10, TroopTerrainCombatPerformance.hiMap, TroopTacticPerformance.hiMap),
    LI(5, 5, TroopTerrainCombatPerformance.liMap, TroopTacticPerformance.liMap),
    AR(6, 2, TroopTerrainCombatPerformance.arMap, TroopTacticPerformance.arMap),
    MA(2, 2, TroopTerrainCombatPerformance.maMap, TroopTacticPerformance.maMap);
    private int strength;
    private int constitution;
    private Map combatPerformanceValue;
    private Map tacticPerformanceValue;
    private Tactics bestTactic;
    private Tactics worstTactic;

    private BaseTroopStats(int strength, int constitution, Map combatPerformanceValue, Map tacticPerformanceValue) {
        this.strength = strength;
        this.constitution = constitution;
        this.combatPerformanceValue = combatPerformanceValue;
        this.tacticPerformanceValue = tacticPerformanceValue;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public Map getCombatPerformanceValue() {
        return combatPerformanceValue;
    }

    public void setCombatPerformanceValue(Map combatPerformanceValue) {
        this.combatPerformanceValue = combatPerformanceValue;
    }

    public Tactics getBestTactic() {
        return bestTactic;
    }

    public void setBestTactic(Tactics bestTactic) {
        this.bestTactic = bestTactic;
    }

    public Tactics getWorstTactic() {
        return worstTactic;
    }

    public void setWorstTactic(Tactics worstTactic) {
        this.worstTactic = worstTactic;
    }

    public Map getTacticPerformanceValue() {
        return tacticPerformanceValue;
    }

    public void setTacticPerformanceValue(Map tacticPerformanceValue) {
        this.tacticPerformanceValue = tacticPerformanceValue;
    }
    
    
}
