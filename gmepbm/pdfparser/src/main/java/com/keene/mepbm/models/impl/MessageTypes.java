package com.keene.mepbm.models.impl;

public enum MessageTypes {

    NATION("NATION"),
    ENCOUNTER("ENCOUNTER"),
    COMBAT("COMBAT"),
    SPECIAL("SPECIAL");
    
    private final String type;

    MessageTypes(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
