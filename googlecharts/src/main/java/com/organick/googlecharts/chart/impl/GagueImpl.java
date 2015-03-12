/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organick.googlecharts.chart.impl;

import com.organick.googlecharts.base.Column;
import com.organick.googlecharts.base.DataTable;
import com.organick.googlecharts.base.Row;
import com.organick.googlecharts.base.impl.ColumnImpl;
import com.organick.googlecharts.base.impl.DataTableImpl;
import com.organick.googlecharts.base.impl.RowImpl;
import com.organick.googlecharts.chart.Gague;
import com.organick.googlecharts.visualization.decorator.base.Decorator;
import com.organick.googlecharts.visualization.decorator.chart.GagueDecorator;
import com.organick.googlecharts.visualization.impl.VisualizationImpl;
import com.organick.googlecharts.visualization.script.LoadableObject;
import com.organick.googlecharts.visualization.script.LoadableScript;
import com.organick.googlecharts.visualization.script.ScriptMetaData;
import com.organick.googlecharts.visualization.script.impl.LoadableObjectImpl;
import com.organick.googlecharts.visualization.script.impl.LoadableScriptImpl;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nkeene
 */
public class GagueImpl extends VisualizationImpl implements Gague {

    private GagueDecorator gagueDecorator;

    public GagueImpl() {
        this.generateUniqueId("Gague");
        ScriptMetaData meta = this.getScriptMetaData();

        LoadableScript jsapi = new LoadableScriptImpl();
        jsapi.setSrc("http://www.google.com/jsapi");
        meta.addLoadableScript(jsapi);

        LoadableObject load = new LoadableObjectImpl();
        load.setName("visualization");
        load.setVersion(1);
        List<String> details = load.getDetails();
        details.add("gauge");
        load.setDetails(details);
        meta.addLoadableObject(load);
        
        DataTable dataTable = this.getDataTable();
        dataTable.setDataType("google.visualization.DataTable");
        dataTable.setChartType("google.visualization.Gauge");
        Column label = new ColumnImpl();
        label.setColumnType(DataTableImpl.STRING_TYPE);
        label.setColumnName("'label'");
        dataTable.addColumn(label);
        Column value = new ColumnImpl();
        value.setColumnType(DataTableImpl.NUMBER_TYPE);
        value.setColumnName("'value'");
        dataTable.addColumn(value);
        this.setDataTable(dataTable);
        this.gagueDecorator = new GagueDecorator();
    }

    public boolean addGague(String label, long value) {
        try {
            Row row = new RowImpl();
            List<String> words = new ArrayList<String>();
            words.add("'"+label+"'");
            words.add(""+value);
            row.setColumnValues(words);
            this.getDataTable().addRow(row);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Decorator getDecorator() {
        return this.gagueDecorator;
    }

    public void setDecorator(Decorator decorator) {
        this.gagueDecorator = (GagueDecorator)decorator;
    }
}
