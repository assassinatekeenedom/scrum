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
import com.organick.googlecharts.chart.AnnotatedTimeLine;
import com.organick.googlecharts.visualization.decorator.base.Decorator;
import com.organick.googlecharts.visualization.decorator.chart.AnnotatedTimeLineDecorator;
import com.organick.googlecharts.visualization.impl.VisualizationImpl;
import com.organick.googlecharts.visualization.script.LoadableObject;
import com.organick.googlecharts.visualization.script.LoadableScript;
import com.organick.googlecharts.visualization.script.ScriptMetaData;
import com.organick.googlecharts.visualization.script.impl.LoadableObjectImpl;
import com.organick.googlecharts.visualization.script.impl.LoadableScriptImpl;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author nkeene
 */
public class AnnotatedTimeLineImpl extends VisualizationImpl implements AnnotatedTimeLine {

    private AnnotatedTimeLineDecorator annotatedTimeLineDecorator;

    public AnnotatedTimeLineImpl(List<String> dataSetLabels) {
        this.generateUniqueId("AnnotatedTimeLine");
        ScriptMetaData meta = this.getScriptMetaData();
        LoadableScript jsap = new LoadableScriptImpl();
        jsap.setSrc("http://www.google.com/jsapi");
        meta.addLoadableScript(jsap);

        LoadableObject load = new LoadableObjectImpl();
        load.setName("visualization");
        load.setVersion(1);
        List<String> details = load.getDetails();
        details.add("annotatedtimeline");
        load.setDetails(details);
        meta.addLoadableObject(load);

        DataTable dataTable = this.getDataTable();
        dataTable.setDataType("google.visualization.DataTable");
        dataTable.setChartType("google.visualization.AnnotatedTimeLine");

        Column date = new ColumnImpl();
        date.setColumnType(DataTableImpl.DATE_TYPE);
        date.setColumnType("'date'");
        dataTable.addColumn(date);

        int count = 1;

        for (String dataSet : dataSetLabels) {

            Column valueColumn = new ColumnImpl();
            valueColumn.setColumnType(DataTableImpl.NUMBER_TYPE);
            valueColumn.setColumnName("'" + dataSet + "'");
            dataTable.addColumn(valueColumn);

            Column labelColumn = new ColumnImpl();
            labelColumn.setColumnType(DataTableImpl.STRING_TYPE);
            labelColumn.setColumnName("'title" + count + "'");
            dataTable.addColumn(labelColumn);

            Column detailColumn = new ColumnImpl();
            detailColumn.setColumnType(DataTableImpl.STRING_TYPE);
            detailColumn.setColumnName("'detail" + count + "'");
            dataTable.addColumn(detailColumn);

            count++;

        }
        this.setDataTable(dataTable);
        this.annotatedTimeLineDecorator = new AnnotatedTimeLineDecorator();
    }

    public boolean addEvent(Date date, List<Long> values, List<String> labels, List<String> details) {
        try {
            if (values.size() == labels.size() && labels.size() == details.size()) {
                Row row = new RowImpl();
                List<String> timeLineEntry = new ArrayList<String>();
                SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy,");
                SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
                String month = monthFormat.format(date);
                int googleMonth = Integer.parseInt(month) - 1;
                SimpleDateFormat dayFormat = new SimpleDateFormat(",dd");
                timeLineEntry.add("new Date(" + yearFormat.format(date) + googleMonth + dayFormat.format(date) + ")");
                for (int x = 0; x < values.size(); x++) {
                    long value = values.get(x);
                    String label = labels.get(x);
                    String detail = details.get(x);
                    timeLineEntry.add(""+value);
                    timeLineEntry.add("'"+label+"'");
                    timeLineEntry.add("'"+detail+"'");
                    row.setColumnValues(timeLineEntry);
                }
                this.getDataTable().addRow(row);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Decorator getDecorator() {
        return this.annotatedTimeLineDecorator;
    }

    public void setDecorator(Decorator decorator) {
        this.annotatedTimeLineDecorator = (AnnotatedTimeLineDecorator) decorator;
    }

}
