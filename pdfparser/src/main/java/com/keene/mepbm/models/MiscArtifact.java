/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keene.mepbm.models;

/**
 *
 * @author nate
 */
public enum MiscArtifact {

    PALANTIR_OF_MINAS_ANOR(MiscPower.Scry_Area, AllegianceEnum.Neutral, "Palantir of Minas Anor"),
    PALANTIR_OF_MINAS_ITHIL(MiscPower.Scry_Area, AllegianceEnum.Neutral, "Palantir of Minas Ithil"),
    PALANTIR_OF_OSGILIATH(MiscPower.Scry_Area, AllegianceEnum.Neutral, "Palantir of Osgiliath"),
    PALANTIR_OF_AMON_SUL(MiscPower.Scry_Area, AllegianceEnum.Neutral, "Palantir of Amon Sul"),
    PALANTIR_OF_ANNUMINAS(MiscPower.Scry_Area, AllegianceEnum.Neutral, "Palantir of Annuminas"),
    PALANTIR_OF_ORTHANC(MiscPower.Scry_Area, AllegianceEnum.Neutral, "Palantir of Orthanc"),
    AMULET_OF_SEA_MASTERY(MiscPower.Open_Seas, AllegianceEnum.Neutral, "Amulet of Sea Mastery"),
    GAERGIL(MiscPower.Open_Seas, AllegianceEnum.Neutral, "Gaergil"),
    STAFF_OF_STORMS(MiscPower.Open_Seas, AllegianceEnum.Neutral, "Staff of Storms");
    private final MiscPower ability;
    private final AllegianceEnum allegiance;
    private final String name;

    MiscArtifact(MiscPower ability, AllegianceEnum allegiance, String name) {
        this.ability = ability;
        this.allegiance = allegiance;
        this.name = name;
    }
}
