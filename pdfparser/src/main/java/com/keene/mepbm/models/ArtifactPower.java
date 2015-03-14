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
public enum ArtifactPower {

    Minor,
    Major,
    Greater;
    private static final List<Integer> minorList = new ArrayList<Integer>();
    

    static {
        minorList.add(10);
        minorList.add(15);
        minorList.add(20);
    }
    private static final List<Integer> majorList = new ArrayList<Integer>();
    

    static {
        majorList.add(25);
        majorList.add(30);
    }
    private static final List<Integer> greaterList = new ArrayList<Integer>();
    

    static {
        greaterList.add(35);
        greaterList.add(40);
    }
}
