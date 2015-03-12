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
import com.organick.googlecharts.chart.OrgChart;
import com.organick.googlecharts.visualization.decorator.base.Decorator;
import com.organick.googlecharts.visualization.decorator.chart.OrgChartDecorator;
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
public class OrgChartImpl extends VisualizationImpl implements OrgChart {

    private OrgChartDecorator wordCloudDecorator;

    public OrgChartImpl() {        
        this.generateUniqueId("OrgChart");
        ScriptMetaData meta = this.getScriptMetaData();
        LoadableScript jsap = new LoadableScriptImpl();
        jsap.setSrc("http://www.google.com/jsapi");
        meta.addLoadableScript(jsap);

        LoadableObject load = new LoadableObjectImpl();
        load.setName("visualization");
        load.setVersion(1);
        List<String> details = load.getDetails();
        details.add("orgchart");
        load.setDetails(details);
        meta.addLoadableObject(load);

        DataTable dataTable = new DataTableImpl();
        dataTable.setDataType("google.visualization.DataTable");
        dataTable.setChartType("google.visualization.OrgChart");

        Column word = new ColumnImpl();
        word.setColumnType(DataTableImpl.STRING_TYPE);
        word.setColumnName("'Word'");

        Column parent = new ColumnImpl();
        parent.setColumnType(DataTableImpl.STRING_TYPE);
        parent.setColumnName("'Parent'");

        Column tooltip = new ColumnImpl();
        tooltip.setColumnType(DataTableImpl.STRING_TYPE);
        tooltip.setColumnName("'ToolTip'");

        dataTable.addColumn(word);
        dataTable.addColumn(parent);
        dataTable.addColumn(tooltip);
        this.setDataTable(dataTable);
        this.wordCloudDecorator = new OrgChartDecorator();
    }

    public Decorator getDecorator() {
        return this.wordCloudDecorator;
    }

    public void setDecorator(Decorator decorator) {
        this.wordCloudDecorator = (OrgChartDecorator) decorator;
    }

    public boolean addWord(String word, String parent, String description) {
        try {
            Row row = new RowImpl();
            List<String> words = new ArrayList<String>();
            if (word != null && !"".equals(word)) {
                words.add("'" + word + "'");
                if (parent != null && !"".equals(parent)) {
                    words.add("'" + parent + "'");
                } else {
                    words.add("null");
                }
                if (description != null && !"".equals(description)) {
                    words.add("'" + description + "'");
                } else {
                    words.add("null");
                }
                row.setColumnValues(words);
                this.getDataTable().addRow(row);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
