/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keene.mepbm.model;

/**
 *
 * @author nate
 */
public enum PCSize {
    CAMP (200, 0, 100, 2000, 100, 0),
    VILLAGE (500, 200, 200, 4000, 80, 2500),
    TOWN (1000, 1000, 1000, 6000, 60, 5000),
    MAJOR_TOWN(2500, 2500, 2500, 8000, 40, 7500),
    CITY (5000, 5000, 5000, 10000, 20, 10000);
    private final int defense;
    private final int forceToThreaten;
    private final int canFeed;
    private final int costToBuild;
    private final int percentProduction;
    private final int revenue;
    
    PCSize(int defense, int forceToThreaten, int canFeed, int costToBuild, int percentProduction, int revenue) {
        this.defense = defense;
        this.forceToThreaten = forceToThreaten;
        this.canFeed = canFeed;
        this.costToBuild = costToBuild;
        this.percentProduction = percentProduction;
        this.revenue = revenue;
    }
}
