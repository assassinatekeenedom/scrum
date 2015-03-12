/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keene.mepbm.combatsimulator.constants;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Galen
 */
public class TroopTacticPerformance {

    public static Map hcMap = new HashMap();
    public static Map lcMap = new HashMap();
    public static Map hiMap = new HashMap();
    public static Map liMap = new HashMap();
    public static Map arMap = new HashMap();
    public static Map maMap = new HashMap();
    

    static {
        hcMap.put(Tactics.STANDARD, TacticPerformance.AVERAGE);
        hcMap.put(Tactics.FLANK, TacticPerformance.AVERAGE);
        hcMap.put(Tactics.SURROUND, TacticPerformance.AVERAGE);
        hcMap.put(Tactics.CHARGE, TacticPerformance.BEST);
        hcMap.put(Tactics.AMBUSH, TacticPerformance.WORST);
        hcMap.put(Tactics.HITANDRUN, TacticPerformance.AVERAGE);
    }
    

    static {
        lcMap.put(Tactics.STANDARD, TacticPerformance.AVERAGE);
        lcMap.put(Tactics.FLANK, TacticPerformance.AVERAGE);
        lcMap.put(Tactics.SURROUND, TacticPerformance.BEST);
        lcMap.put(Tactics.CHARGE, TacticPerformance.AVERAGE);
        lcMap.put(Tactics.AMBUSH, TacticPerformance.WORST);
        lcMap.put(Tactics.HITANDRUN, TacticPerformance.AVERAGE);
    }
    

    static {
        hiMap.put(Tactics.STANDARD, TacticPerformance.AVERAGE);
        hiMap.put(Tactics.FLANK, TacticPerformance.BEST);
        hiMap.put(Tactics.SURROUND, TacticPerformance.WORST);
        hiMap.put(Tactics.CHARGE, TacticPerformance.AVERAGE);
        hiMap.put(Tactics.AMBUSH, TacticPerformance.AVERAGE);
        hiMap.put(Tactics.HITANDRUN, TacticPerformance.AVERAGE);
    }
    

    static {
        liMap.put(Tactics.STANDARD, TacticPerformance.AVERAGE);
        liMap.put(Tactics.FLANK, TacticPerformance.AVERAGE);
        liMap.put(Tactics.SURROUND, TacticPerformance.AVERAGE);
        liMap.put(Tactics.CHARGE, TacticPerformance.WORST);
        liMap.put(Tactics.AMBUSH, TacticPerformance.AVERAGE);
        liMap.put(Tactics.HITANDRUN, TacticPerformance.BEST);
    }
    

    static {
        arMap.put(Tactics.STANDARD, TacticPerformance.AVERAGE);
        arMap.put(Tactics.FLANK, TacticPerformance.WORST);
        arMap.put(Tactics.SURROUND, TacticPerformance.AVERAGE);
        arMap.put(Tactics.CHARGE, TacticPerformance.AVERAGE);
        arMap.put(Tactics.AMBUSH, TacticPerformance.BEST);
        arMap.put(Tactics.HITANDRUN, TacticPerformance.AVERAGE);
    }
    

    static {
        maMap.put(Tactics.STANDARD, TacticPerformance.AVERAGE);
        maMap.put(Tactics.FLANK, TacticPerformance.AVERAGE);
        maMap.put(Tactics.SURROUND, TacticPerformance.AVERAGE);
        maMap.put(Tactics.CHARGE, TacticPerformance.WORST);
        maMap.put(Tactics.AMBUSH, TacticPerformance.AVERAGE);
        maMap.put(Tactics.HITANDRUN, TacticPerformance.BEST);
    }
}
