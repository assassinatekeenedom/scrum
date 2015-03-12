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
import com.organick.googlecharts.chart.RotatingCloud;
import com.organick.googlecharts.visualization.decorator.base.Decorator;
import com.organick.googlecharts.visualization.decorator.chart.RotatingCloudDecorator;
import com.organick.googlecharts.visualization.impl.VisualizationImpl;
import com.organick.googlecharts.visualization.script.LoadableScript;
import com.organick.googlecharts.visualization.script.ScriptMetaData;
import com.organick.googlecharts.visualization.script.impl.LoadableScriptImpl;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nkeene
 */
public class RotatingCloudImpl extends VisualizationImpl implements RotatingCloud {

    private RotatingCloudDecorator wordCloudDecorator;

    public RotatingCloudImpl() {
        this.generateUniqueId("RotatingCloud");
        ScriptMetaData meta = this.getScriptMetaData();

        LoadableScript wcjs = new LoadableScriptImpl();
        wcjs.setSrc("http://word-cumulus-goog-vis.googlecode.com/svn/trunk/wordcumulus.js");
        meta.addLoadableScript(wcjs);

        LoadableScript swfjs = new LoadableScriptImpl();
        swfjs.setSrc("http://word-cumulus-goog-vis.googlecode.com/svn/trunk/swfobject.js");
        meta.addLoadableScript(swfjs);

        LoadableScript jsapi = new LoadableScriptImpl();
        jsapi.setSrc("http://www.google.com/jsapi");
        meta.addLoadableScript(jsapi);
        
        DataTable dataTable = this.getDataTable();
        dataTable.setDataType("google.visualization.DataTable");
        dataTable.setChartType("gviz_word_cumulus.WordCumulus");

        Column words = new ColumnImpl();
        words.setColumnType(DataTableImpl.STRING_TYPE);
        words.setColumnName("'words'");
        dataTable.addColumn(words);

        Column url = new ColumnImpl();
        url.setColumnType(DataTableImpl.STRING_TYPE);
        url.setColumnName("'url'");
        dataTable.addColumn(url);

        this.setDataTable(dataTable);
        this.wordCloudDecorator = new RotatingCloudDecorator();
    }

    public boolean addWord(String word, String url) {
        try {
            Row row = new RowImpl();
            List<String> words = new ArrayList<String>();
            words.add("'"+word+"'");
            words.add("'"+url+"'");
            row.setColumnValues(words);
            this.getDataTable().addRow(row);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Decorator getDecorator() {
        return this.wordCloudDecorator;
    }

    public void setDecorator(Decorator decorator) {
        this.wordCloudDecorator = (RotatingCloudDecorator)decorator;
    }
}
