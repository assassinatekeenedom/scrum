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
import com.organick.googlecharts.chart.WordCloud;
import com.organick.googlecharts.visualization.decorator.base.Decorator;
import com.organick.googlecharts.visualization.decorator.chart.WordCloudDecorator;
import com.organick.googlecharts.visualization.impl.VisualizationImpl;
import com.organick.googlecharts.visualization.script.LoadableScript;
import com.organick.googlecharts.visualization.script.LoadableStylesheet;
import com.organick.googlecharts.visualization.script.ScriptMetaData;
import com.organick.googlecharts.visualization.script.impl.LoadableScriptImpl;
import com.organick.googlecharts.visualization.script.impl.LoadableStylesheetImpl;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nkeene
 */
public class WordCloudImpl extends VisualizationImpl implements WordCloud {

    private WordCloudDecorator wordCloudDecorator;

    public WordCloudImpl() {
        this.generateUniqueId("WordCloud");
        ScriptMetaData meta = this.getScriptMetaData();

        LoadableScript wcjs = new LoadableScriptImpl();
        wcjs.setSrc("http://visapi-gadgets.googlecode.com/svn/trunk/wordcloud/wc.js");
        meta.addLoadableScript(wcjs);

        LoadableScript jsapi = new LoadableScriptImpl();
        jsapi.setSrc("http://www.google.com/jsapi");
        meta.addLoadableScript(jsapi);

        LoadableStylesheet wccss = new LoadableStylesheetImpl();
        wccss.setHref("http://visapi-gadgets.googlecode.com/svn/trunk/wordcloud/wc.css");
        meta.addLoadableStylesheet(wccss);
        
        DataTable dataTable = this.getDataTable();
        dataTable.setDataType("google.visualization.DataTable");
        dataTable.setChartType("WordCloud");
        Column column = new ColumnImpl();
        column.setColumnType(DataTableImpl.STRING_TYPE);
        column.setColumnName("'words'");
        dataTable.addColumn(column);
        this.setDataTable(dataTable);
        this.wordCloudDecorator = new WordCloudDecorator();
    }

    public boolean addWord(String word) {
        try {
            Row row = new RowImpl();
            List<String> words = new ArrayList<String>();
            words.add("'"+word+"'");
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
        this.wordCloudDecorator = (WordCloudDecorator)decorator;
    }
}
