/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keene.mepbm.model;

/**
 *
 * @author nate
 */
public enum Fortification {
    TOWER (2000, 1000, 1000),
    FORT (6000, 3000, 3000),
    CASTLE (10000, 5000, 5000),
    KEEP (16000, 8000, 8000),
    CITADEL (24000, 12000, 12000);
    private final int defense;
    private final int gold;
    private final int timber;
    
    Fortification(int defense, int gold, int timber){
        this.defense = defense;
        this.gold = gold;
        this.timber = timber;
    }
}
