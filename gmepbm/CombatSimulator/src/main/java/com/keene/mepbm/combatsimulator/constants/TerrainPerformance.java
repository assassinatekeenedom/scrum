/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keene.mepbm.combatsimulator.constants;

/**
 *
 * @author Galen
 */
public enum TerrainPerformance {

    POOR(60),
    GOOD(100),
    AVERAGE(80);
    private int value;

    TerrainPerformance(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
