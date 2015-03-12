/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keene.mepbm.models;

/**
 *
 * @author nate
 */
public enum SkillArtifact {

    E_MERE_VARDO(Skill.Mage, ArtifactPower.Minor, AllegianceEnum.Free_People, "E Mere Vardo"),
    BLACK_STAFF(Skill.Mage, ArtifactPower.Minor, AllegianceEnum.Neutral, "Black Staff"),
    CORANTIR(Skill.Mage, ArtifactPower.Minor, AllegianceEnum.Neutral, "Corantir"),
    OSSANNA(Skill.Mage, ArtifactPower.Minor, AllegianceEnum.Neutral, "Ossanna"),
    STAFF_OF_THE_SERPENT(Skill.Mage, ArtifactPower.Minor, AllegianceEnum.Neutral, "Staff of the Serpent"),
    THE_BLACK_BOOK(Skill.Mage, ArtifactPower.Minor, AllegianceEnum.Neutral, "The Black Book"),
    HEADBAND_OF_SLAEG(Skill.Mage, ArtifactPower.Minor, AllegianceEnum.Neutral, "Headband of Slaeg"),
    BLUE_RING(Skill.Mage, ArtifactPower.Minor, AllegianceEnum.Dark_Servants, "Blue Ring"),
    DEEPWOOD_BRACELET(Skill.Mage, ArtifactPower.Minor, AllegianceEnum.Neutral, "Deepwood Bracelet"),
    E_THROND(Skill.Mage, ArtifactPower.Minor, AllegianceEnum.Neutral, "E Thrond"),
    TABLETS_OF_DARK_KNOWLEDGE(Skill.Mage, ArtifactPower.Minor, AllegianceEnum.Dark_Servants, "Tablets of Dark Knowledge"),
    TALISMAN_OF_ABSORPTION(Skill.Mage, ArtifactPower.Minor, AllegianceEnum.Dark_Servants, "Talisman of Absorption"),
    STAFF_OF_BRONZE(Skill.Mage, ArtifactPower.Minor, AllegianceEnum.Neutral, "Staff of Bronze"),
    OVIR_CROWN(Skill.Mage, ArtifactPower.Minor, AllegianceEnum.Neutral, "Ovier Crown"),
    RING_OF_SOUL_TAKING(Skill.Mage, ArtifactPower.Minor, AllegianceEnum.Neutral, "Ring of Soul-taking"),
    STAFF_OF_EARTHMASTERY(Skill.Mage, ArtifactPower.Minor, AllegianceEnum.Neutral, "Staff of Earthmastery"),
    STAFF_OF_THE_WANDERER(Skill.Mage, ArtifactPower.Minor, AllegianceEnum.Neutral, "Staff of the Wanderer"),
    ORB_OF_DARK_SEEING(Skill.Mage, ArtifactPower.Minor, AllegianceEnum.Dark_Servants, "Orb of Dark Seeing"),
    ORB_OF_SEEING(Skill.Mage, ArtifactPower.Major, AllegianceEnum.Neutral, "Orb of Seeing"),
    WOLOR_PRIEST_RING(Skill.Mage, ArtifactPower.Major, AllegianceEnum.Neutral, "Wolor Priest Ring"),
    COLLAR_OF_MIGHT(Skill.Mage, ArtifactPower.Major, AllegianceEnum.Neutral, "Collar of Might"),
    MARANYA(Skill.Mage, ArtifactPower.Major, AllegianceEnum.Neutral, "Maranya"),
    RING_OF_STARGAZING(Skill.Mage, ArtifactPower.Major, AllegianceEnum.Neutral, "Ring of Stargazing"),
    THOLOGAER_CIRYATANO(Skill.Mage, ArtifactPower.Major, AllegianceEnum.Neutral, "Thologaer Ciryatano"),
    NAZGUAGA(Skill.Mage, ArtifactPower.Major, AllegianceEnum.Dark_Servants, "Nazguaga"),
    RING_OF_BLEEDING(Skill.Mage, ArtifactPower.Major, AllegianceEnum.Dark_Servants, "Ring of Bleeding"),
    RING_OF_IRON_MAGIC(Skill.Mage, ArtifactPower.Major, AllegianceEnum.Dark_Servants, "Ring of Iron Magic"),
    DRAGON_HELM_AND_ARMOUR(Skill.Mage, ArtifactPower.Major, AllegianceEnum.Dark_Servants, "Dragon Helm & Armour"),
    TINCULIN(Skill.Mage, ArtifactPower.Greater, AllegianceEnum.Neutral, "Tinculin"),
    CLOAK_OF_PROTECTION(Skill.Agent, ArtifactPower.Minor, AllegianceEnum.Neutral, "Cloak of Protection"),
    LISTENING_HELM(Skill.Agent, ArtifactPower.Minor, AllegianceEnum.Neutral, "Listening Helm"),
    RAT_GAUNTLETS(Skill.Agent, ArtifactPower.Minor, AllegianceEnum.Neutral, "Rat Gauntlets"),
    MIRAMARTH(Skill.Agent, ArtifactPower.Minor, AllegianceEnum.Dark_Servants, "Miramarth"),
    CLOAK_OF_THE_HEAVENS(Skill.Agent, ArtifactPower.Minor, AllegianceEnum.Neutral, "Cloak of the Heavens"),
    CLOAK_OF_DUVORN(Skill.Agent, ArtifactPower.Minor, AllegianceEnum.Neutral, "Cloak of Duvorn"),
    RING_OF_IMPERSONATION(Skill.Agent, ArtifactPower.Major, AllegianceEnum.Neutral, "Ring of Impersonation"),
    RING_OF_CURUFIN(Skill.Agent, ArtifactPower.Major, AllegianceEnum.Neutral, "Ring of Curufin"),
    RING_OF_BINDING(Skill.Agent, ArtifactPower.Major, AllegianceEnum.Dark_Servants, "Ring of Binding"),
    RING_OF_WIND(Skill.Agent, ArtifactPower.Greater, AllegianceEnum.Neutral, "Ring of Wind"),
    CLOAK_OF_HIDING(Skill.Stealth, ArtifactPower.Minor, AllegianceEnum.Neutral, "Cloak of Hiding"),
    HELM_OF_SHADOW(Skill.Stealth, ArtifactPower.Minor, AllegianceEnum.Neutral, "Helm of Shadow"),
    WOOD_SHADOW(Skill.Stealth, ArtifactPower.Minor, AllegianceEnum.Neutral, "Wood-shadow"),
    ELENYA(Skill.Stealth, ArtifactPower.Minor, AllegianceEnum.Neutral, "Elenya"),
    CLOAK_OF_VALACIRCA(Skill.Stealth, ArtifactPower.Minor, AllegianceEnum.Neutral, "Cloak of Valacirca"),
    COLLOHWESTA(Skill.Stealth, ArtifactPower.Major, AllegianceEnum.Neutral, "Collohwesta"),
    RING_OF_THE_WITCH_KING(Skill.Stealth, ArtifactPower.Major, AllegianceEnum.Dark_Servants, "Ring of the Witch-king"),
    ROBES_OF_AMAN(Skill.Stealth, ArtifactPower.Major, AllegianceEnum.Free_People, "Robes of Aman"),
    BRACERS_OF_THE_MISTS(Skill.Stealth, ArtifactPower.Major, AllegianceEnum.Neutral, "Bracers of the Mists"),
    DAECOLLO(Skill.Stealth, ArtifactPower.Major, AllegianceEnum.Neutral, "Daecollo"),
    ROBES_OF_LOIL(Skill.Stealth, ArtifactPower.Major, AllegianceEnum.Neutral, "Robes of Loil"),
    CLOAK_OF_THE_ABYSS(Skill.Stealth, ArtifactPower.Greater, AllegianceEnum.Neutral, "Cloak of the Abyss"),
    BRACERS_OF_CHENNACATT(Skill.Command, ArtifactPower.Minor, AllegianceEnum.Neutral, "Bracers of Chennacatt"),
    ANGBOR(Skill.Command, ArtifactPower.Minor, AllegianceEnum.Neutral, "Angbor"),
    BOOTS_OF_IRON(Skill.Command, ArtifactPower.Minor, AllegianceEnum.Neutral, "Boots of Iron"),
    HELM_OF_SEN_JEY(Skill.Command, ArtifactPower.Minor, AllegianceEnum.Neutral, "Helm of Sen Jey"),
    RING_OF_AXARDIL(Skill.Command, ArtifactPower.Minor, AllegianceEnum.Neutral, "Ring of Axardil"),
    MORGUL_PLATE(Skill.Command, ArtifactPower.Minor, AllegianceEnum.Dark_Servants, "Morgul Plate"),
    DRAGON_HELM_OF_DOR_LOMIN(Skill.Command, ArtifactPower.Minor, AllegianceEnum.Neutral, "Dragon Helm of Dor-Lomin"),
    DURINS_ARMOR_AND_SHIELD(Skill.Command, ArtifactPower.Minor, AllegianceEnum.Neutral, "Durin's Armor & Shield"),
    HORSE_LORDS_SHIELD(Skill.Command, ArtifactPower.Minor, AllegianceEnum.Neutral, "Horse-lord's Shield"),
    RED_ROBES(Skill.Command, ArtifactPower.Minor, AllegianceEnum.Neutral, "Red Robes"),
    HELM_OF_THE_DARK(Skill.Command, ArtifactPower.Minor, AllegianceEnum.Dark_Servants, "Helm of the Dark"),
    ROBES_OF_THE_ORC_PRIESTS(Skill.Command, ArtifactPower.Minor, AllegianceEnum.Dark_Servants, "Robes of the Orc Priests"),
    SKULL_HELM(Skill.Command, ArtifactPower.Minor, AllegianceEnum.Dark_Servants, "Skull Helm"),
    SILVER_ROD_OF_ANDUNI(Skill.Command, ArtifactPower.Minor, AllegianceEnum.Free_People, "Silver Rod of Anduni"),
    BELT_OF_DURIN(Skill.Command, ArtifactPower.Minor, AllegianceEnum.Neutral, "Belt of Durin"),
    FOAM_LIGHT(Skill.Command, ArtifactPower.Minor, AllegianceEnum.Neutral, "Foam-light"),
    GAERENNON(Skill.Command, ArtifactPower.Minor, AllegianceEnum.Neutral, "Gaerennon"),
    SHIELD_OF_ANARION(Skill.Command, ArtifactPower.Minor, AllegianceEnum.Neutral, "Shield of Anarion"),
    GULTHALION(Skill.Command, ArtifactPower.Major, AllegianceEnum.Neutral, "Guthalion"),
    HELM_OF_ISILDUR(Skill.Command, ArtifactPower.Major, AllegianceEnum.Neutral, "Helm of Isildur"),
    HELM_OF_THE_MUMAK_KING(Skill.Command, ArtifactPower.Major, AllegianceEnum.Neutral, "Helm of the Mumak-king"),
    COLLAR_OF_COMMAND(Skill.Command, ArtifactPower.Major, AllegianceEnum.Neutral, "Collar of Command"),
    BLACK_SCALE(Skill.Command, ArtifactPower.Major, AllegianceEnum.Dark_Servants, "Black Scale"),
    ULUKAI(Skill.Command, ArtifactPower.Major, AllegianceEnum.Dark_Servants, "Ulukai"),
    RING_OF_BARAHIR(Skill.Command, ArtifactPower.Greater, AllegianceEnum.Free_People, "Ring of Barahir"),
    MIRLAMMENRIM(Skill.Emissary, ArtifactPower.Minor, AllegianceEnum.Neutral, "Mirlammenrim"),
    VOICE_OF_THE_DARK_TOWER(Skill.Emissary, ArtifactPower.Minor, AllegianceEnum.Dark_Servants, "Voice of the Dark Tower"),
    PECTORAL(Skill.Emissary, ArtifactPower.Major, AllegianceEnum.Neutral, "Pectoral");
    private final Skill skill;
    private final ArtifactPower power;
    private final AllegianceEnum allegiance;
    private final String name;

    SkillArtifact(Skill skill, ArtifactPower power, AllegianceEnum allegiance, String name) {
        this.skill = skill;
        this.power = power;
        this.allegiance = allegiance;
        this.name = name;
    }
}
