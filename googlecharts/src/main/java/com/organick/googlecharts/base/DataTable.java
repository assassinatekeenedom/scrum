/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organick.googlecharts.base;

import java.util.List;

/**
 *
 * @author nkeene
 */
public interface DataTable {

    public List<Column> getColumns();

    public List<Row> getRows();

    public String getTableName();

    public void setTableName(String tableName);

    public String getChartType();

    public void setChartType(String chartType);

    public String getDataType();

    public void setDataType(String dataType);

    public boolean addColumn(Column column);

    public boolean addRow(Row row);

    public List<String> getDecorators();

    public void addDecorator(String option, String value);

    public void addDecorator(String option, int value);

    public void addDecorator(String option, double value);
}
