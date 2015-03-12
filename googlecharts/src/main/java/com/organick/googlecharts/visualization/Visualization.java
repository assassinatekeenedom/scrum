/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organick.googlecharts.visualization;

import com.organick.googlecharts.base.DataTable;
import com.organick.googlecharts.visualization.decorator.base.Decorator;
import com.organick.googlecharts.visualization.script.ScriptMetaData;

/**
 *
 * @author nkeene
 */
public interface Visualization {

    public String getUniqueId();

    public void generateUniqueId(String type);

    public Decorator getDecorations();

    public void setDecorations(Decorator decorations);

    public DataTable getDataTable();

    public void setDataTable(DataTable dataTable);

    public ScriptMetaData getScriptMetaData();

    public void setScriptMetaData(ScriptMetaData scriptMetaData);
}
