/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keene.mepbm.models;

/**
 *
 * @author nate
 */
public enum TroopType {
    HEAVY_CAVALRY (16, 16, 2, 6),
    LIGHT_CAVALRY (8, 8, 2, 3),
    HEAVY_INFANTRY (10, 10, 1, 4),
    LIGHT_INFANTRY (5, 5, 1, 2),
    ARCHERS (6, 2, 1, 2),
    MEN_AT_ARMS (2, 2, 1, 1);
    private final int strength;
    private final int constitution;
    private final int foodPerTurn;
    private final int goldPerTurn;
    
    TroopType (int strength, int constitution, int foodPerTurn, int goldPerTurn){
        this.strength = strength;
        this.constitution = constitution;
        this.foodPerTurn = foodPerTurn;
        this.goldPerTurn = goldPerTurn;
    }
}
