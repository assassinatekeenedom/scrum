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
import com.organick.googlecharts.chart.Treemap;
import com.organick.googlecharts.visualization.decorator.base.Decorator;
import com.organick.googlecharts.visualization.decorator.chart.TreemapDecorator;
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
public class TreemapImpl extends VisualizationImpl implements Treemap {

    private TreemapDecorator treemapDecorator;

    public TreemapImpl() {
        this.generateUniqueId("Treemap");
        ScriptMetaData meta = this.getScriptMetaData();

        LoadableScript jsap = new LoadableScriptImpl();
        jsap.setSrc("http://www.google.com/jsapi");
        meta.addLoadableScript(jsap);

        LoadableObject load = new LoadableObjectImpl();
        load.setName("visualization");
        load.setVersion(1);
        List<String> details = load.getDetails();
        details.add("treemap");
        load.setDetails(details);
        meta.addLoadableObject(load);

        DataTable baseInformation = new DataTableImpl();
        baseInformation.setDataType("google.visualization.DataTable");
        baseInformation.setChartType("google.visualization.TreeMap");

        Column module = new ColumnImpl();
        module.setColumnType(DataTableImpl.STRING_TYPE);
        module.setColumnName("'module'");
        baseInformation.addColumn(module);

        Column component = new ColumnImpl();
        component.setColumnType(DataTableImpl.STRING_TYPE);
        component.setColumnName("'component'");
        baseInformation.addColumn(component);

        Column size = new ColumnImpl();
        size.setColumnType(DataTableImpl.NUMBER_TYPE);
        size.setColumnName("'size'");
        baseInformation.addColumn(size);

        Column colorAsRange = new ColumnImpl();
        colorAsRange.setColumnType(DataTableImpl.NUMBER_TYPE);
        colorAsRange.setColumnName("'colorAsRange'");
        baseInformation.addColumn(colorAsRange);

        this.setDataTable(baseInformation);
        this.treemapDecorator = new TreemapDecorator();
    }

    public Decorator getDecorator() {
        return this.treemapDecorator;
    }

    public void setDecorator(Decorator decorator) {
        this.treemapDecorator = (TreemapDecorator) decorator;
    }

    public boolean addEntry(String self, String parent, Long size, Long scale) {
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
                words.add("" + scale);
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
