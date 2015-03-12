/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keene.mepbm.models;

/**
 *
 * @author nate
 */
public enum CombatSpell {

    CALL_FIRE(SpellType.OFFENSIVE, SpellList.FIRE_MASTERY, 150, 0, 202, SpellDifficulty.EASY, "Call Fire"),
    WILD_FLAMES(SpellType.OFFENSIVE, SpellList.FIRE_MASTERY, 150, 100, 204, SpellDifficulty.EASY, "Wild  Flames"),
    WALL_OF_FIRE(SpellType.OFFENSIVE, SpellList.FIRE_MASTERY, 150, 50, 206, SpellDifficulty.EASY, "Wall of Fire"),
    FIRE_BOLTS(SpellType.OFFENSIVE, SpellList.FIRE_MASTERY, 1000, 0, 232, SpellDifficulty.AVERAGE, "Fire Bolts"),
    FIRE_BALLS(SpellType.OFFENSIVE, SpellList.FIRE_MASTERY, 1000, 500, 234, SpellDifficulty.AVERAGE, "Fire Balls"),
    FIRE_STORMS(SpellType.OFFENSIVE, SpellList.FIRE_MASTERY, 1000, 200, 236, SpellDifficulty.AVERAGE, "Fire Storms"),
    SUMMON_FIRE_SPIRITS(SpellType.OFFENSIVE, SpellList.FIRE_MASTERY, 1500, 500, 240, SpellDifficulty.HARD, "Summon Fire Spirits"),
    WORDS_OF_PAIN(SpellType.OFFENSIVE, SpellList.WORD_MASTERY, 250, 0, 208, SpellDifficulty.EASY, "Words of Pain"),
    WORDS_OF_CALM(SpellType.OFFENSIVE, SpellList.WORD_MASTERY, 250, 150, 210, SpellDifficulty.EASY, "Words of Calm"),
    WORDS_OF_PARALYSIS(SpellType.OFFENSIVE, SpellList.WORD_MASTERY, 250, 50, 212, SpellDifficulty.EASY, "Words of Paralysis"),
    WORDS_OF_AGONY(SpellType.OFFENSIVE, SpellList.WORD_MASTERY, 600, 0, 220, SpellDifficulty.AVERAGE, "Words of Agony"),
    WORDS_OF_STUN(SpellType.OFFENSIVE, SpellList.WORD_MASTERY, 600, 300, 222, SpellDifficulty.AVERAGE, "Words of Stun"),
    WORDS_OF_COMMAND(SpellType.OFFENSIVE, SpellList.WORD_MASTERY, 600, 150, 224, SpellDifficulty.AVERAGE, "Words of Command"),
    WORDS_OF_DEATH(SpellType.OFFENSIVE, SpellList.WORD_MASTERY, 1750, 500, 242, SpellDifficulty.HARD, "Words of Death"),
    CALL_WINDS(SpellType.OFFENSIVE, SpellList.WIND_MASTERY, 400, 0, 214, SpellDifficulty.EASY, "Call Winds"),
    WILD_WINDS(SpellType.OFFENSIVE, SpellList.WIND_MASTERY, 400, 200, 216, SpellDifficulty.EASY, "Wild Winds"),
    WALL_OF_WIND(SpellType.OFFENSIVE, SpellList.WIND_MASTERY, 400, 100, 218, SpellDifficulty.EASY, "Wall of Wind"),
    CHILL_BOLTS(SpellType.OFFENSIVE, SpellList.WIND_MASTERY, 800, 0, 226, SpellDifficulty.AVERAGE, "Chill Bolts"),
    FROST_BALLS(SpellType.OFFENSIVE, SpellList.WIND_MASTERY, 800, 400, 228, SpellDifficulty.AVERAGE, "Frost Balls"),
    WIND_STORMS(SpellType.OFFENSIVE, SpellList.WIND_MASTERY, 800, 200, 230, SpellDifficulty.AVERAGE, "Wind Storms"),
    SUMMON_WIND_SPIRITS(SpellType.OFFENSIVE, SpellList.WIND_MASTERY, 1250, 500, 238, SpellDifficulty.HARD, "Summon Wind Spirits"),
    BARRIERS(SpellType.DEFENSIVE, SpellList.BARRIER_MASTERY, 500, 0, 102, SpellDifficulty.EASY, "Barriers"),
    DEFLECTIONS(SpellType.DEFENSIVE, SpellList.BARRIER_MASTERY, 1000, 0, 106, SpellDifficulty.AVERAGE, "Deflections"),
    SHIELDS(SpellType.DEFENSIVE, SpellList.BARRIER_MASTERY, 1750, 0, 112, SpellDifficulty.HARD, "Shields"),
    BARRIER_WALLS(SpellType.DEFENSIVE, SpellList.BARRIER_MASTERY, 1750, 250, 114, SpellDifficulty.HARD, "Barrier Walls"),
    RESISTANCES(SpellType.DEFENSIVE, SpellList.RESISTANCE_MASTERY, 750, 0, 104, SpellDifficulty.EASY, "Resistances"),
    BLESSINGS(SpellType.DEFENSIVE, SpellList.RESISTANCE_MASTERY, 1250, 0, 108, SpellDifficulty.AVERAGE, "Blessings"),
    PROTECTIONS(SpellType.DEFENSIVE, SpellList.RESISTANCE_MASTERY, 1500, 0, 110, SpellDifficulty.HARD, "Protections"),
    FORCE_WALLS(SpellType.DEFENSIVE, SpellList.RESISTANCE_MASTERY, 1500, 500, 116, SpellDifficulty.HARD, "Force Walls"),
    MINOR_HEAL(SpellType.HEALING, SpellList.HEALING_MASTERY, 20, 0, 2, SpellDifficulty.EASY, "Minor Heal"),
    HEAL_TRUE(SpellType.HEALING, SpellList.HEALING_MASTERY, 100, 0, 8, SpellDifficulty.HARD, "Heal True"),
    MAJOR_HEAL(SpellType.HEALING, SpellList.HEALING_WAYS, 35, 0, 4, SpellDifficulty.EASY, "Major Heal"),
    GREATER_HEAL(SpellType.HEALING, SpellList.HEALING_WAYS, 50, 0, 6, SpellDifficulty.AVERAGE, "Greater Heal");
    private final SpellType spellType;
    private final SpellList spellList;
    private final int base;
    private final int offset;
    private final int spellNumber;
    private final SpellDifficulty spellDifficulty;
    private final String name;

    CombatSpell(SpellType spellType, SpellList spellList, int base, int offset, int spellNumber, SpellDifficulty spellDifficulty, String name) {
        this.spellType = spellType;
        this.spellList = spellList;
        this.base = base;
        this.offset = offset;
        this.spellNumber = spellNumber;
        this.spellDifficulty = spellDifficulty;
        this.name = name;
    }
}