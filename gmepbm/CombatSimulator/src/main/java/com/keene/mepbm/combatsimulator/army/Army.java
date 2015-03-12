/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.keene.mepbm.combatsimulator.army;

import com.keene.mepbm.combatsimulator.troops.Troops;
import java.util.ArrayList;

/**
 *
 * @author Galen
 */
public class Army extends ArrayList<Troops>{
    
    private int troopStrength;
    
     public int getTroopStrength() {
        return troopStrength;
    }

    public void setTroopStrength(int troopStrength) {
        this.troopStrength = troopStrength;
    }

}
