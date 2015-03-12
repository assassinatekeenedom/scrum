/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keene.mepbm.combatsimulator;

import com.keene.mepbm.combatsimulator.army.Army;
import com.keene.mepbm.combatsimulator.constants.BaseTroopStats;
import com.keene.mepbm.combatsimulator.constants.Tactics;
import com.keene.mepbm.combatsimulator.constants.Terrain;
import com.keene.mepbm.combatsimulator.controller.CombatModifiedTroops;
import com.keene.mepbm.combatsimulator.controller.TroopFactory;
import com.keene.mepbm.combatsimulator.troops.Armor;
import com.keene.mepbm.combatsimulator.troops.Training;
import com.keene.mepbm.combatsimulator.troops.Weapons;
import junit.framework.TestCase;

/**
 *
 * @author Galen
 */
public class CombatBaseTroopsTest extends TestCase {

    public CombatBaseTroopsTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    // TODO add test methods here. The name must begin with 'test'. For example:
    // public void testHello() {}
    public void testBaseHC() {

        TroopFactory.createTroop(500, BaseTroopStats.HC, new Training(69), new Weapons(60), new Armor(40));
    }

    public void testBaseLI() {

        TroopFactory.createTroop(500, BaseTroopStats.LI, new Training(40), new Weapons(30), new Armor(30));
    }

    public void testBaseHI() {

        TroopFactory.createTroop(1000, BaseTroopStats.HI, new Training(40), new Weapons(30), new Armor(30));
    }

    public void testBaseAR() {

        TroopFactory.createTroop(500, BaseTroopStats.AR, new Training(30), new Weapons(60), new Armor(10));
    }

    public void testArmy1() {
        Army myArmy = new Army();
        myArmy.add(TroopFactory.createTroop(500, BaseTroopStats.HC, new Training(69), new Weapons(60), new Armor(40)));
        myArmy.add(TroopFactory.createTroop(500, BaseTroopStats.LI, new Training(40), new Weapons(30), new Armor(30)));
        myArmy.setTroopStrength(CombatModifiedTroops.caculateTroopStrength(myArmy, Terrain.PLAINS, Tactics.CHARGE));

    }
}
