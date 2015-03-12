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
import com.organick.googlecharts.chart.PieChart;
import com.organick.googlecharts.visualization.decorator.base.Decorator;
import com.organick.googlecharts.visualization.decorator.chart.PieChartDecorator;
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
public class PieChartImpl extends VisualizationImpl implements PieChart {

    private PieChartDecorator pieChartDecorator;

    public PieChartImpl() {
        this.generateUniqueId("PieChart");
        ScriptMetaData meta = this.getScriptMetaData();
        LoadableScript jsap = new LoadableScriptImpl();
        jsap.setSrc("http://www.google.com/jsapi");
        meta.addLoadableScript(jsap);

        LoadableObject load = new LoadableObjectImpl();
        load.setName("visualization");
        load.setVersion(1);
        List<String> details = load.getDetails();
        details.add("corechart");
        load.setDetails(details);
        meta.addLoadableObject(load);

        DataTable dataTable = this.getDataTable();        
        dataTable.setDataType("google.visualization.DataTable");
        dataTable.setChartType("google.visualization.PieChart");
        Column labelColumn = new ColumnImpl();
        labelColumn.setColumnType(DataTableImpl.STRING_TYPE);
        labelColumn.setColumnName("'label'");
        dataTable.addColumn(labelColumn);
        Column valueColumn = new ColumnImpl();
        valueColumn.setColumnType(DataTableImpl.NUMBER_TYPE);
        valueColumn.setColumnName("'value'");
        dataTable.addColumn(valueColumn);
        this.setDataTable(dataTable);

        this.pieChartDecorator = new PieChartDecorator();
    }

    public boolean addData(String label, int value) {
        try {
            Row row = new RowImpl();
            List<String> pieValues = new ArrayList<String>();
            pieValues.add("'" + label + "'");
            pieValues.add(Integer.toString(value));
            row.setColumnValues(pieValues);
            this.getDataTable().addRow(row);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addData(String label, long value) {
        try {
            Row row = new RowImpl();
            List<String> pieValues = new ArrayList<String>();
            pieValues.add("'" + label + "'");
            pieValues.add(Long.toString(value));
            row.setColumnValues(pieValues);
            this.getDataTable().addRow(row);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addData(String label, double value) {
        try {
            Row row = new RowImpl();
            List<String> pieValues = new ArrayList<String>();
            pieValues.add("'" + label + "'");
            pieValues.add(Double.toString(value));
            row.setColumnValues(pieValues);
            this.getDataTable().addRow(row);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addData(String label, float value) {
        try {
            Row row = new RowImpl();
            List<String> pieValues = new ArrayList<String>();
            pieValues.add("'" + label + "'");
            pieValues.add(Float.toString(value));
            row.setColumnValues(pieValues);
            this.getDataTable().addRow(row);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addData(String label, String value) {
        try {
            Row row = new RowImpl();
            List<String> pieValues = new ArrayList<String>();
            pieValues.add("'" + label + "'");
            pieValues.add(value);
            row.setColumnValues(pieValues);
            this.getDataTable().addRow(row);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Decorator getDecorator() {
        return this.pieChartDecorator;
    }

    public void setDecorator(Decorator decorator) {
        this.pieChartDecorator = (PieChartDecorator) decorator;
    }
}
