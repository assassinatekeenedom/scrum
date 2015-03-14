/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keene.mepbm.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nate
 */
public enum Skill {

    Command("Command"),
    Agent("Agent"),
    Emissary("Emissary"),
    Mage("Mage"),
    Stealth("Stealth"),
    Challenge("Challenge"),
    Core("Core");
    private final String name;

    private static final List<Skill> coreList = new ArrayList<Skill>();

    static{
        coreList.add(Skill.Command);
        coreList.add(Skill.Agent);
        coreList.add(Skill.Emissary);
        coreList.add(Skill.Mage);
    }
    Skill(String name) {
        this.name = name; 
    }

    public String getName() {
        return name;
    }

    public static List<Skill> getCoreList(){
        return coreList;
    }
}
