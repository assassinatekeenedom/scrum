package com.keene.mepbm.models;

public enum AllegianceEnum {
    Free_People ("Free People"),
    Neutral ("Neutral"),
    Dark_Servants ("Dark Servants");
    private final String allegiance;
    
    AllegianceEnum(String allegiance){
        this.allegiance = allegiance;
    }

    public String getAllegiance() {
        return allegiance;
    }
}
