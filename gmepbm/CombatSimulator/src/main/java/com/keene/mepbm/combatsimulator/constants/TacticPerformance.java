/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.keene.mepbm.combatsimulator.constants;

/**
 *
 * @author Galen
 */
public enum TacticPerformance {

    WORST(90),
    BEST(115),
    AVERAGE(102);
    private int value;

    private TacticPerformance(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    
    
}
