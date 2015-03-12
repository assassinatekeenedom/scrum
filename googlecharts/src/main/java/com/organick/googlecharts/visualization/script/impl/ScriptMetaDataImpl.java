/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organick.googlecharts.visualization.script.impl;

import com.organick.googlecharts.visualization.script.LoadableObject;
import com.organick.googlecharts.visualization.script.LoadableScript;
import com.organick.googlecharts.visualization.script.LoadableStylesheet;
import com.organick.googlecharts.visualization.script.ScriptMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nkeene
 */
public class ScriptMetaDataImpl implements ScriptMetaData {

    private List<LoadableObject> loadableObjects;
    private List<LoadableScript> javascriptURLs;
    private List<LoadableStylesheet> loadableStylesheet;

    public ScriptMetaDataImpl() {
        this.loadableObjects = new ArrayList<LoadableObject>();
        this.loadableStylesheet = new ArrayList<LoadableStylesheet>();
        this.javascriptURLs = new ArrayList<LoadableScript>();
    }

    public void addLoadableObject(LoadableObject loadableObject) {
        this.loadableObjects.add(loadableObject);
    }

    public void addLoadableScript(LoadableScript javascriptURL) {
        this.javascriptURLs.add(javascriptURL);
    }

    public void addLoadableStylesheet(LoadableStylesheet stylesheetURL) {
        this.loadableStylesheet.add(stylesheetURL);
    }

    public List<LoadableObject> getLoadableObjects() {
        return loadableObjects;
    }

    public List<LoadableScript> getLoadableScripts() {
        return javascriptURLs;
    }

    public List<LoadableStylesheet> getLoadableStylesheets() {
        return loadableStylesheet;
    }
}
