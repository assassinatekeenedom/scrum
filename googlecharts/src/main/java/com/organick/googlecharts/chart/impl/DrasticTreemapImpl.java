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
import com.organick.googlecharts.chart.DrasticTreemap;
import com.organick.googlecharts.visualization.decorator.base.Decorator;
import com.organick.googlecharts.visualization.decorator.chart.DrasticTreemapDecorator;
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
public class DrasticTreemapImpl extends VisualizationImpl implements DrasticTreemap {

    private DrasticTreemapDecorator drasticTreemapDecorator;

    public DrasticTreemapImpl(List<String> dataSetLabels) {
        this.drasticTreemapDecorator = new DrasticTreemapDecorator();
        this.generateUniqueId("DrasticTreemap");
        ScriptMetaData meta = this.getScriptMetaData();

        LoadableScript jsap = new LoadableScriptImpl();
        jsap.setSrc("http://www.google.com/jsapi");
        meta.addLoadableScript(jsap);

//        LoadableScript drastic = new LoadableScriptImpl();
//        drastic.setSrc("http://www.drasticdata.nl/DrasticTreemapGApi/DrasticTreemapGApi.js");
//        meta.addLoadableScript(drastic);

        LoadableObject loadVis = new LoadableObjectImpl();
        loadVis.setName("visualization");
        loadVis.setVersion(1);
        meta.addLoadableObject(loadVis);
        LoadableObject swfObj = new LoadableObjectImpl();
        swfObj.setName("swfobject");
        swfObj.setVersion(2.2);
        meta.addLoadableObject(swfObj);

        DataTable baseInformation = new DataTableImpl();
        baseInformation.setDataType("google.visualization.DataTable");
        baseInformation.setChartType("drasticdata.DrasticTreemap");

        Column module = new ColumnImpl();
        module.setColumnType(DataTableImpl.STRING_TYPE);
        module.setColumnName("'category'");
        baseInformation.addColumn(module);
        this.drasticTreemapDecorator.setLabelColumn("category");

        Column component = new ColumnImpl();
        component.setColumnType(DataTableImpl.STRING_TYPE);
        component.setColumnName("'topic'");
        baseInformation.addColumn(component);
        this.drasticTreemapDecorator.setGroupByColumn("topic");

        for (String dataLabel : dataSetLabels) {
            Column size = new ColumnImpl();
            size.setColumnType(DataTableImpl.NUMBER_TYPE);
            size.setColumnName("'"+dataLabel+"'");
            baseInformation.addColumn(size);
            this.drasticTreemapDecorator.addVariable(dataLabel);
        }

        this.setDataTable(baseInformation);        
    }

    public Decorator getDecorator() {
        return this.drasticTreemapDecorator;
    }

    public void setDecorator(Decorator decorator) {
        this.drasticTreemapDecorator = (DrasticTreemapDecorator) decorator;
    }

    public boolean addEntry(String self, String parent, Long size) {
        try {
            if (self != null && !"".equals(self)) {
                Row row = new RowImpl();
                List<String> words = new ArrayList<String>();
                words.add("'" + self + "'");
                if (parent == null || "".equals(parent)) {
                    words.add("null");
                } else {
                    words.add("'" + parent + "'");
                }
                words.add("" + size);
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
