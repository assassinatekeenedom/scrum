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
public class TroopTerrainCombatPerformance {

   public static Map hcMap = new HashMap();
   public static Map lcMap = new HashMap();
   public static Map hiMap = new HashMap();
   public static Map liMap = new HashMap();
   public static Map arMap = new HashMap();
   public static Map maMap = new HashMap();

    static {
        hcMap.put(Terrain.SHORE, TerrainPerformance.AVERAGE);
        hcMap.put(Terrain.PLAINS, TerrainPerformance.GOOD);
        hcMap.put(Terrain.ROUGH, TerrainPerformance.POOR);
        hcMap.put(Terrain.FOREST, TerrainPerformance.POOR);
        hcMap.put(Terrain.DESERT, TerrainPerformance.AVERAGE);
        hcMap.put(Terrain.SWAMP, TerrainPerformance.POOR);
        hcMap.put(Terrain.MOUNTAIN, TerrainPerformance.POOR);
    }
    static {
        lcMap.put(Terrain.SHORE, TerrainPerformance.GOOD);
        lcMap.put(Terrain.PLAINS, TerrainPerformance.GOOD);
        lcMap.put(Terrain.ROUGH, TerrainPerformance.AVERAGE);
        lcMap.put(Terrain.FOREST, TerrainPerformance.POOR);
        lcMap.put(Terrain.DESERT, TerrainPerformance.GOOD);
        lcMap.put(Terrain.SWAMP, TerrainPerformance.POOR);
        lcMap.put(Terrain.MOUNTAIN, TerrainPerformance.POOR);
    }
    static {
        hiMap.put(Terrain.SHORE, TerrainPerformance.AVERAGE);
        hiMap.put(Terrain.PLAINS, TerrainPerformance.GOOD);
        hiMap.put(Terrain.ROUGH, TerrainPerformance.AVERAGE);
        hiMap.put(Terrain.FOREST, TerrainPerformance.AVERAGE);
        hiMap.put(Terrain.DESERT, TerrainPerformance.AVERAGE);
        hiMap.put(Terrain.SWAMP, TerrainPerformance.POOR);
        hiMap.put(Terrain.MOUNTAIN, TerrainPerformance.POOR);
    }
    static {
        liMap.put(Terrain.SHORE, TerrainPerformance.AVERAGE);
        liMap.put(Terrain.PLAINS, TerrainPerformance.AVERAGE);
        liMap.put(Terrain.ROUGH, TerrainPerformance.GOOD);
        liMap.put(Terrain.FOREST, TerrainPerformance.AVERAGE);
        liMap.put(Terrain.DESERT, TerrainPerformance.AVERAGE);
        liMap.put(Terrain.SWAMP, TerrainPerformance.AVERAGE);
        liMap.put(Terrain.MOUNTAIN, TerrainPerformance.AVERAGE);
    }
    static {
        arMap.put(Terrain.SHORE, TerrainPerformance.AVERAGE);
        arMap.put(Terrain.PLAINS, TerrainPerformance.GOOD);
        arMap.put(Terrain.ROUGH, TerrainPerformance.GOOD);
        arMap.put(Terrain.FOREST, TerrainPerformance.AVERAGE);
        arMap.put(Terrain.DESERT, TerrainPerformance.GOOD);
        arMap.put(Terrain.SWAMP, TerrainPerformance.POOR);
        arMap.put(Terrain.MOUNTAIN, TerrainPerformance.AVERAGE);
    }
    static {
        maMap.put(Terrain.SHORE, TerrainPerformance.AVERAGE);
        maMap.put(Terrain.PLAINS, TerrainPerformance.GOOD);
        maMap.put(Terrain.ROUGH, TerrainPerformance.GOOD);
        maMap.put(Terrain.FOREST, TerrainPerformance.AVERAGE);
        maMap.put(Terrain.DESERT, TerrainPerformance.AVERAGE);
        maMap.put(Terrain.SWAMP, TerrainPerformance.AVERAGE);
        maMap.put(Terrain.MOUNTAIN, TerrainPerformance.AVERAGE);
    }
}
