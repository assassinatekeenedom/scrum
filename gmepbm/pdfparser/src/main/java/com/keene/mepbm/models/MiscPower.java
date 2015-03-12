/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keene.mepbm.models;

/**
 *
 * @author nate
 */
public enum MiscPower {

    Scry_Area ("Scry Area"),
    Open_Seas ("Open Seas Movement");
    private final String description;
    
    MiscPower(String description){
        this.description = description;
    }
}
