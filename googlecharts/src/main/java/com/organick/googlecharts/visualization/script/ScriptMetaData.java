/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organick.googlecharts.visualization.script;

import java.util.List;

/**
 *
 * @author nkeene
 */
public interface ScriptMetaData {

    public void addLoadableObject(LoadableObject loadableObject);

    public void addLoadableScript(LoadableScript javascriptURL);

    public void addLoadableStylesheet(LoadableStylesheet stylesheetURL);

    public List<LoadableObject> getLoadableObjects();

    public List<LoadableScript> getLoadableScripts();

    public List<LoadableStylesheet> getLoadableStylesheets();
}
