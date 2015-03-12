/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organick.googlecharts.visualization.impl;

import com.organick.googlecharts.visualization.script.impl.ScriptMetaDataImpl;
import com.organick.googlecharts.visualization.decorator.base.Decorator;
import com.organick.googlecharts.base.DataTable;
import com.organick.googlecharts.base.impl.DataTableImpl;
import com.organick.googlecharts.visualization.Visualization;
import com.organick.googlecharts.visualization.script.ScriptMetaData;
import java.util.Calendar;

/**
 *
 * @author nkeene
 */
public abstract class VisualizationImpl implements Visualization {

    private String uniqueId;
    private DataTable dataTable;
    private ScriptMetaData scriptMetaData;
    private Decorator decorations;

    public VisualizationImpl() {
        scriptMetaData = new ScriptMetaDataImpl();
        dataTable = new DataTableImpl();
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void generateUniqueId(String type) {
        this.uniqueId = type + Math.round(Calendar.getInstance().getTimeInMillis() * Math.random());
    }

    public Decorator getDecorations() {
        this.decorations.buildDecoratorString();
        return decorations;
    }

    public void setDecorations(Decorator decorations) {
        this.decorations = decorations;
    }

    public DataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(DataTable dataTable) {
        this.dataTable = dataTable;
    }

    public ScriptMetaData getScriptMetaData() {
        return scriptMetaData;
    }

    public void setScriptMetaData(ScriptMetaData scriptMetaData) {
        this.scriptMetaData = scriptMetaData;
    }

   
}
