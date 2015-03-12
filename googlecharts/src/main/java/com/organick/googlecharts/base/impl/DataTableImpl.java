/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organick.googlecharts.base.impl;

import com.organick.googlecharts.base.Column;
import com.organick.googlecharts.base.DataTable;
import com.organick.googlecharts.base.Row;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nkeene
 */
public class DataTableImpl implements DataTable {

    public static final String STRING_TYPE = "'string'";
    public static final String DATE_TYPE = "'date'";
    public static final String NUMBER_TYPE = "'number'";
    private String tableName;
    private String dataType;
    private String chartType;
    private List<String> decorators;
    private List<String> packages;
    private List<Column> columns;
    private List<Row> rows;

    public DataTableImpl() {
        this.packages = new ArrayList<String>();
        this.decorators = new ArrayList<String>();
        this.columns = new ArrayList<Column>();
        this.rows = new ArrayList<Row>();
    }

    public List<Column> getColumns() {
        return columns;
    }

    public List<Row> getRows() {
        return rows;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
    public String getChartType() {
        return chartType;
    }

    public void setChartType(String chartType) {
        this.chartType = chartType;
    }

    public List<String> getPackages() {
        return packages;
    }

    public boolean addColumn(Column column) {
        try {
            this.columns.add(column);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addRow(Row row) {
        try {
            List<String> columnValues = row.getColumnValues();
            if (columnValues.size() == columns.size()) {
                this.rows.add(row);
                return true;
            } else {
                System.out.println("Cannot Add Row -- # of columns and values in the row do now match!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addPackage(String apackage) {
        try {
            this.packages.add(apackage);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<String> getDecorators() {
        return decorators;
    }

    public void addDecorator(String option, String value) {
        String decorator = option + ":'" + value + "'";
        this.decorators.add(decorator);
    }
    public void addDecorator(String option, int value) {
        String decorator = option + ":" + value;
        this.decorators.add(decorator);
    }
    public void addDecorator(String option, double value) {
        String decorator = option + ":" + value;
        this.decorators.add(decorator);
    }
}
